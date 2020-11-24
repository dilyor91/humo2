package com.example.humo2.UtilOfb;

import com.example.humo2.dto.CardsDto;
import com.example.humo2.dto.ClientDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/*
 *
 *  @A Sabirov Jakhongir
 *
 */
public class MapperTest implements RowMapper<CardsDto> {


    @Override
    public CardsDto mapRow(ResultSet resultSet, int i) throws SQLException {
        CardsDto card = new CardsDto();
        card.setCardType(resultSet.getNString(1));
        card.setAccount(resultSet.getNString(2));
        return card;
    }
}
