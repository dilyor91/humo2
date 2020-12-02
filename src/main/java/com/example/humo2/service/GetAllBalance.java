package com.example.humo2.service;

import com.example.humo2.dto.CardsDto;
import com.example.humo2.dto.ClientDto;
import com.example.humo2.dto.PaymentCardResponse;

import java.util.List;

/*
 *
 *  @A Sabirov Jakhongir
 *
 */
public interface GetAllBalance {

     List<PaymentCardResponse.Body.PaymentCard> response(ClientDto client);
     PaymentCardResponse responseByXml(String clientId,String mfo);
}
