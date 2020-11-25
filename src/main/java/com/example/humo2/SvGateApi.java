package com.example.humo2;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/*
 *
 *  @A Sabirov Jakhongir
 *
 */
public class SvGateApi {

    private static RestTemplate restTemplate = new RestTemplate();
    private static final String api = "http://10.10.110.47:8080/SvGateClient/sender";

    public static String getBalanceUzcardById(String cardId,String phoneNumber){
        final String[] balance = {"0"};
        final String[] phone={"0"};
        JSONObject object = new JSONObject();
        JSONArray array=new JSONArray();
        JSONObject jsonObject=new JSONObject();
        array.put(cardId);
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
                .exchange(api, HttpMethod.POST, entity, String.class);
        if(getResponse.getStatusCode()==HttpStatus.OK){
            JSONObject response = new JSONObject(getResponse.getBody());
            //hello world
            JSONArray result = response.getJSONArray("result");
            //     HashMap hashMap = (HashMap) result.get(0);
            //     System.out.println(hashMap.get("balance"));
            result.forEach(i->{
                JSONObject itar = (JSONObject) i;
                phone[0]=String.valueOf(itar.get("phone"));
                if (phone[0]!= null && phoneNumber!=null){
                   if(phone[0].equals(phoneNumber)) {
                balance[0] = String.valueOf(Double.parseDouble(String.valueOf((itar.get("balance"))))/100);}
                }
                else
                    balance[0]="0";
            });
            return balance[0];
        }
        return "0";
    }





}
