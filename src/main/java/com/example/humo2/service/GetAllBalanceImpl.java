package com.example.humo2.service;

import com.example.humo2.HumoGetApi;
import com.example.humo2.SvGateApi;
import com.example.humo2.UtilOfb.MapperTest;
import com.example.humo2.UtilOfb.OfbUtils;
//import com.example.humo2.dto.CardTypeE;
import com.example.humo2.dto.CardsDto;
import com.example.humo2.dto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/*
 *
 *  @A Sabirov Jakhongir
 *
 */
@Service
public class GetAllBalanceImpl implements  GetAllBalance{

    @Autowired
    Environment environment;

    @Autowired
    private JdbcTemplate jdbcTemplate;



    // 12 seqund

    private static StringBuilder stringBuilder;
    private static Logger logger = (Logger) Logger.getLogger(String.valueOf(GetAllBalanceImpl.class));

    // final Logger logger = Logger.getLogger(String.valueOf(GetAllBalanceImpl.class));
    @Override
    public List<CardsDto> response(ClientDto client) {
        long startTime = System.nanoTime();
     //   List<ClientDto> list =  jdbcTemplate.query("select c.name from client_current c where c.id = ?",new MapperTest(),client.getClient());
        Map<String, Object> result = executeProcedure(client.getClient(),client.getMfo());
        List<CardsDto> cards = getCardsDtos(result);
        showTime(startTime);
        if (cards != null) return cards;
        return null;
    }

    private List<CardsDto> getCardsDtos(Map<String, Object> result) {
        logger.info("Procedura ishga tushyabdi");
        CardsDto cardsDto=new CardsDto();
        List<String>cardIds=new ArrayList<>();
        if(result.get("N_ERROR_CODE").equals(new BigDecimal(Long.parseLong("0"))))
        {
            logger.info("Error_code 0");
            List<CardsDto> cards =   jdbcTemplate.query(OfbUtils.SQL, new MapperTest());
            for (CardsDto i : cards)
            {

              if(i.getCardType().equals("sv")){
                  if(i.getBalance()!=-1){
                      logger.info("SV ishga tushyabdi " + i.getCardNumber());
                      //i.setBalance(Double.parseDouble(SvGateApi.getBalanceUzcardById(i.getCardID(),i.getPhoneNumber())));
                      cardsDto=SvGateApi.getBalanceUzcardById(i);
                      i.setBalance(cardsDto.getBalance());
                      i.setState(cardsDto.getState());
                      System.out.println("sv --------  "+cardsDto.getState());
                      logger.info("SV yakunlandi " + i.getCardNumber() + " " + i.getBalance());
                  }
                  else
                      i.setBalance(0);
                }

              if(i.getCardType().equals("gl")) {
                  if (i.getBalance() != -1) {
                      logger.info("GL ishga tushyabdi " + i.getCardNumber());
                      i.setBalance(Double.parseDouble(HumoGetApi.poster(i.getCardNumber())));
                      logger.info("GL yakunlandi " + i.getCardNumber() + " " + i.getBalance());
                  } else i.setBalance(0);
              }
              //     System.out.println(i);
                stringBuilder.append(OfbUtils.generateAnswer(i));
            }
            logger.info("Hammasi PCdaki balans olishlar Yakunlandi ");
            return cards;
        }else{
            logger.info("Hatolik ro`y berdi proceduradan 1 qaytdi");
        }
        return null;
    }

    private Map<String, Object> executeProcedure(String client,String mfo) {
        SimpleJdbcCall procedure = new SimpleJdbcCall(jdbcTemplate).
                withSchemaName(environment.getProperty("schemaName")).
                withCatalogName(environment.getProperty("packageName")).
                withProcedureName(environment.getProperty("procedureName")).
                declareParameters(
                        new SqlParameter("S_CLIENT_ID", Types.VARCHAR),
                        new SqlParameter("S_MFO",Types.VARCHAR),
                        new SqlInOutParameter("N_ERROR_CODE",Types.NUMERIC)
                );
        return procedure.execute(client,mfo,0);
    }

    @Override
    public String responseByXml(String clientId, String mfo) {
        logger.info("Bu yerga " + clientId + "  " + mfo + " Keldi");
        stringBuilder = new StringBuilder();
        stringBuilder.append("<cards>\n");
        long startTime = System.nanoTime();
        logger.info("boshlangan vaqti " + startTime);
        Map<String, Object> result = executeProcedure(clientId,mfo);
        getCardsDtos(result);
        stringBuilder.append("</cards>\n");
        showTime(startTime);
        logger.info("butunlay yakunlandi  clientID: " + clientId + "  MFO: " + mfo);
        return stringBuilder.toString();
    }


    private void showTime(long startTime) {
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        long convert = TimeUnit.SECONDS.convert(totalTime, TimeUnit.NANOSECONDS);
        logger.info("Tamom bo`lgan vaqti  shuncha sequnda" + convert);
        System.out.println(totalTime + " S: " + convert);
    }
}
