package com.example.humo2;

import com.example.humo2.UtilOfb.OfbUtils;
import com.example.humo2.dto.CardsDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/*
 *
 *  @A Sabirov Jakhongir
 *
 */
public class SvGateApi {

    private static RestTemplate restTemplate;


    public static String getBalanceUzcardById(String cardId,String phoneNumber){

        Duration duration = Duration.ofSeconds(5);
        restTemplate = new RestTemplateBuilder().setConnectTimeout(duration).setConnectTimeout(duration).build();
        final String[] balance = {"0"};
        final String[] phone={"0"};
        final String[] status={"0"};
        JSONObject object = new JSONObject();
        JSONArray array=new JSONArray();
        JSONObject jsonObject=new JSONObject();
        array.put(cardId);
        // array.put("969A028DFA530698E0530100007FE074");
        object.put("ids",array);
        jsonObject.put("params",object);
        jsonObject.put("authorization",OfbUtils.SV_GATE_AUTHO);
        jsonObject.put("method","cards.get");
        jsonObject.put("id","7777");
        jsonObject.put("timeout","10");
        
        jsonObject.put("svgateurl",OfbUtils.SV_GATE_API);
        jsonObject.put("jsonrpc","2.0");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        List<MediaType> list = new ArrayList<>();
        list.add(MediaType.APPLICATION_JSON);
        headers.setAccept(list);
        HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), headers);
        ResponseEntity<String> getResponse = restTemplate
                .exchange(OfbUtils.FIDO_API_INSIDE, HttpMethod.POST, entity, String.class);
        if(getResponse.getStatusCode()==HttpStatus.OK){
            JSONObject response = new JSONObject(getResponse.getBody());
            //hello world
            JSONArray result = response.getJSONArray("result");
            //     HashMap hashMap = (HashMap) result.get(0);
            //     System.out.println(hashMap.get("balance"));
            result.forEach(i->{
                JSONObject itar = (JSONObject) i;
                phone[0] = String.valueOf(itar.get("phone"));
                status[0]=String.valueOf(itar.get("status"));

                if (phone[0]!= null && phoneNumber!=null){
                    if(phoneNumber.contains(phone[0])) {
                        balance[0] = String.valueOf(Double.parseDouble(String.valueOf((itar.get("balance"))))/100);
                    }
                }
                else
                    balance[0]="0";

            });
            return balance[0];
        }
        return "0";
    }

    public static CardsDto getBalanceUzcardById(CardsDto cardsDto){

        Duration duration = Duration.ofSeconds(5);
        restTemplate = new RestTemplateBuilder().setConnectTimeout(duration).setConnectTimeout(duration).build();
        final String[] balance = {"0"};
        final String[] phone={"0"};
        final String[] status={"0"};
        JSONObject object = new JSONObject();
        JSONArray array=new JSONArray();
        JSONObject jsonObject=new JSONObject();
        array.put(cardsDto.getCardID());
        // array.put("969A028DFA530698E0530100007FE074");
        object.put("ids",array);
        jsonObject.put("params",object);
        jsonObject.put("authorization","b2ZiOk9yaUBlbnQkYW4kOE1iOnsrI0ZpblslbXZFYg==");
        jsonObject.put("method","cards.get");
        jsonObject.put("id","7777");
        jsonObject.put("timeout","10");
        jsonObject.put("svgateurl","https://172.16.249.33:47007/api/jsonrpc");
        jsonObject.put("jsonrpc","2.0");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        List<MediaType> list = new ArrayList<>();
        list.add(MediaType.APPLICATION_JSON);
        headers.setAccept(list);
        HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), headers);
        ResponseEntity<String> getResponse = restTemplate
                .exchange(OfbUtils.FIDO_API_INSIDE, HttpMethod.POST, entity, String.class);
        if(getResponse.getStatusCode()==HttpStatus.OK){
            JSONObject response = new JSONObject(getResponse.getBody());
            //hello world
            JSONArray result = response.getJSONArray("result");
            //     HashMap hashMap = (HashMap) result.get(0);
            //     System.out.println(hashMap.get("balance"));
            result.forEach(i->{
                JSONObject itar = (JSONObject) i;
                phone[0] = String.valueOf(itar.get("phone"));
                status[0]=String.valueOf(itar.get("status"));
                System.out.println("phone "+phone[0]);
                System.out.println("state "+status[0]);
                if (!status[0].equals("0"))
                {
                    cardsDto.setBalance(0);
                    cardsDto.setState("BLOCKED");
                } else {
                    if (phone[0] != null && cardsDto.getPhoneNumber() != null) {
                        if (cardsDto.getPhoneNumber().contains(phone[0])) {
                            cardsDto.setBalance(Double.parseDouble(String.valueOf((itar.get("balance")))) / 100);
                            // balance[0] = String.valueOf(Double.parseDouble(String.valueOf((itar.get("balance"))))/100);
                        } else
                            cardsDto.setBalance(0);
                    } else
                        cardsDto.setBalance(0);
                    //balance[0]="0";
                }
            });
            return cardsDto;
        }
        return cardsDto;
    }





}
