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
        CardsDto cardsDto = new CardsDto();
        cardsDto.setCardType(resultSet.getNString(1));
        cardsDto.setAccount(resultSet.getNString(2));
        cardsDto.setBalance(resultSet.getDouble(3));
        cardsDto.setBranch(resultSet.getNString(4));
        cardsDto.setCardBelonging(resultSet.getNString(5));
        cardsDto.setCardKind(resultSet.getNString(6));
        cardsDto.setCardListVist(resultSet.getInt(7));
        cardsDto.setCardNumberMask(resultSet.getNString(8));
        cardsDto.setCardSort(resultSet.getNString(9));
        cardsDto.setCardHolderName(resultSet.getNString(10));
        cardsDto.setCurrencyCode(resultSet.getNString(11));
        cardsDto.setCurrencyIsoCode(resultSet.getNString(12));
        cardsDto.setEmbossedName(resultSet.getNString(13));
        cardsDto.setExpirationDate(resultSet.getDate(14));
        cardsDto.setExtId(resultSet.getNString(15));
        cardsDto.setRejection(resultSet.getInt(16));
        cardsDto.setServiceTerms(resultSet.getString(17));
        cardsDto.setState(resultSet.getString(18));
        cardsDto.setTempBlocking(resultSet.getInt(19));
        cardsDto.setType(resultSet.getNString(20));
        cardsDto.setVisibleAccount(resultSet.getInt(21));
        cardsDto.setPhoneNumber(resultSet.getNString(22));
        cardsDto.setCardNumber(resultSet.getNString(23));
        cardsDto.setClientId(resultSet.getInt(24));
        cardsDto.setContractId(resultSet.getInt(25));
        cardsDto.setIsAbroadUsing(resultSet.getInt(26));
        cardsDto.setIsInternetUsing(resultSet.getInt(27));
        cardsDto.setReplwoutConv(resultSet.getInt(28));
        cardsDto.setWithdraw(resultSet.getInt(29));
        cardsDto.setCardID(resultSet.getNString(30));
        return cardsDto;
    }
}
