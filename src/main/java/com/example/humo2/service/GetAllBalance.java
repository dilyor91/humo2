package com.example.humo2.service;

import com.example.humo2.dto.CardsDto;
import com.example.humo2.dto.ClientDto;

import java.util.List;

/*
 *
 *  @A Sabirov Jakhongir
 *
 */
public interface GetAllBalance {

     List<CardsDto> response(ClientDto client);
     String responseByXml(String clientId,String mfo);
}
