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

    @Override
    public String response(ClientDto client) {
        long startTime = System.nanoTime();
     //   List<ClientDto> list =  jdbcTemplate.query("select c.name from client_current c where c.id = ?",new MapperTest(),client.getClient());
        SimpleJdbcCall procedure = new SimpleJdbcCall(jdbcTemplate).
                withSchemaName(environment.getProperty("schemaName")).
                withCatalogName(environment.getProperty("packageName")).
                withProcedureName(environment.getProperty("procedureName")).
                declareParameters(
                        new SqlParameter("S_CLIENT_ID", Types.VARCHAR),
                        new SqlParameter("S_MFO",Types.VARCHAR),
                        new SqlInOutParameter("N_ERROR_CODE",Types.NUMERIC)
                );
        Map<String,Object> result = procedure.execute(client.getClient(),client.getMfo(),0);

        System.out.println(result.get("N_ERROR_CODE"));
        if(result.get("N_ERROR_CODE").equals(new BigDecimal(Long.parseLong("0"))))
        {
            List<CardsDto> cards =   jdbcTemplate.query(OfbUtils.sql, new MapperTest());
            System.out.println(cards);
            for (CardsDto i : cards){
              if(i.getCardType().equals("sv")){
                    System.out.println("SV " + i.getCardNumber() + " " + i.getCardID() + " " + SvGateApi.getBalanceUzcardById(i.getCardID()));
                }
              if(i.getCardType().equals("gl")){
                    System.out.println("GL " + i.getCardNumber() +" " + HumoGetApi.poster(i.getCardNumber()));
                }

                if(i.getCardType().equals("tet")){
                    System.out.println("TET: " +i.getCardNumber() + " " + i.getBalance());
                }
            }
        }
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        long convert = TimeUnit.SECONDS.convert(totalTime, TimeUnit.NANOSECONDS);
        System.out.println(totalTime +" S: " + convert);
        return null;
    }
}
