package com.example.humo2.service;

import com.example.humo2.MapperTest;
import com.example.humo2.dto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import java.util.List;

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


    @Override
    public String response(String client) {
        List<ClientDto> list =  jdbcTemplate.query("select c.name from client_current c where c.id = ?",new MapperTest(),client);
        SimpleJdbcCall procedure = new SimpleJdbcCall(jdbcTemplate).
                withSchemaName(environment.getProperty("schemaName")).
                withCatalogName(environment.getProperty("packageName")).
                withProcedureName(environment.getProperty("procedureName"));


        return null;
    }
}
