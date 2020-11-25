package com.example.humo2.service;

import com.example.humo2.HumoGetApi;
import com.example.humo2.SvGateApi;
import com.example.humo2.UtilOfb.MapperTest;
import com.example.humo2.UtilOfb.OfbUtils;
import com.example.humo2.dto.CardTypeE;
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
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
        System.out.println(result.get("N_ERROR_CODE"));
        if(result.get("N_ERROR_CODE").equals(new BigDecimal(Long.parseLong("0"))))
        {
            List<CardsDto> cards =   jdbcTemplate.query(OfbUtils.sql, new MapperTest());
            for (CardsDto i : cards){
              if(i.getCardType().equals("sv")){
                    i.setBalance(Double.parseDouble(SvGateApi.getBalanceUzcardById(i.getCardID())));
                }
              if(i.getCardType().equals("gl")){
                  i.setBalance(Double.parseDouble(HumoGetApi.poster(i.getCardNumber())));
                }
                System.out.println(i);
                stringBuilder.append(OfbUtils.generateAnswer(i));
            }
            return cards;
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
        stringBuilder = new StringBuilder();
        stringBuilder.append("<cards>\n");
        long startTime = System.nanoTime();
        Map<String, Object> result = executeProcedure(clientId,mfo);
        getCardsDtos(result);
        stringBuilder.append("</cards>\n");
        showTime(startTime);
        return stringBuilder.toString();
    }


    private void showTime(long startTime) {
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        long convert = TimeUnit.SECONDS.convert(totalTime, TimeUnit.NANOSECONDS);
        System.out.println(totalTime + " S: " + convert);
    }
}
