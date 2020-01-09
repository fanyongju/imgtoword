package com.fyj.imgtoword.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fyj.imgtoword.service.ImgToWordService;
import com.fyj.imgtoword.util.GZIPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


/**
 * @author fanyongju
 * @Title: TestController
 * @date 2019/2/25 17:25
 */
@RestController
public class TestController {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ImgToWordService imgToWordService;

    @GetMapping(value = "/ad.xml", produces = MediaType.APPLICATION_XML_VALUE)
    public String ad(HttpServletResponse response) throws Exception{
        response.setHeader("access-control-allow-headers", "Origin, X-Requested-With, Content-Type, Accept, Range");
        response.setHeader("access-control-allow-credentials", "true");
        response.setHeader("access-control-allow-origin", "https://www.radiantmediaplayer.com");
        File file = new File("E:\\Project\\imgtoword\\file\\ad.xml");
        if (!file.exists()) {
            return null;
        }
        FileInputStream inputStream = new FileInputStream(file);
        int length = inputStream.available();
        byte bytes[] = new byte[length];
        inputStream.read(bytes);
        inputStream.close();
        String xml = new String(bytes, StandardCharsets.UTF_8);
        return xml;
    }

    @GetMapping("/data")
    public String data(String start, String end, String group) {
        System.out.println("date: " + imgToWordService.toString());
        System.out.println("start: " + start);
        System.out.println("end: " + end);
        return "{\"data\":[{\"date\":\"2019-01-01\",\"impression_count\":\"18\",\"revenue\":\"0.0110896820\"},{\"date\":\"2019-01-02\",\"impression_count\":\"2091\",\"revenue\":\"1.5133340250\"},{\"date\":\"2019-01-03\",\"impression_count\":\"5184\",\"revenue\":\"3.6940172970\"},{\"date\":\"2019-01-04\",\"impression_count\":\"6307\",\"revenue\":\"4.4512654430\"},{\"date\":\"2019-01-05\",\"impression_count\":\"5994\",\"revenue\":\"4.1599704550\"},{\"date\":\"2019-01-06\",\"impression_count\":\"2788\",\"revenue\":\"1.9265458360\"},{\"date\":\"2019-01-09\",\"impression_count\":\"4170\",\"revenue\":\"2.9130912660\"},{\"date\":\"2019-01-10\",\"impression_count\":\"5339\",\"revenue\":\"3.6465326200\"},{\"date\":\"2019-01-11\",\"impression_count\":\"4310\",\"revenue\":\"2.8551668470\"},{\"date\":\"2019-01-12\",\"impression_count\":\"3052\",\"revenue\":\"1.9811858440\"},{\"date\":\"2019-01-13\",\"impression_count\":\"2968\",\"revenue\":\"1.8875538280\"},{\"date\":\"2019-01-14\",\"impression_count\":\"3731\",\"revenue\":\"2.5759747200\"},{\"date\":\"2019-01-15\",\"impression_count\":\"3345\",\"revenue\":\"2.2992850870\"},{\"date\":\"2019-01-16\",\"impression_count\":\"3465\",\"revenue\":\"2.5791723750\"},{\"date\":\"2019-01-17\",\"impression_count\":\"8001\",\"revenue\":\"5.1669366910\"},{\"date\":\"2019-01-18\",\"impression_count\":\"9808\",\"revenue\":\"5.3861391640\"},{\"date\":\"2019-01-19\",\"impression_count\":\"9806\",\"revenue\":\"5.2726529510\"},{\"date\":\"2019-01-20\",\"impression_count\":\"10192\",\"revenue\":\"5.4745016730\"},{\"date\":\"2019-01-21\",\"impression_count\":\"10068\",\"revenue\":\"5.4829540710\"},{\"date\":\"2019-01-22\",\"impression_count\":\"9717\",\"revenue\":\"5.3190956420\"},{\"date\":\"2019-01-23\",\"impression_count\":\"7543\",\"revenue\":\"5.2362395500\"},{\"date\":\"2019-01-24\",\"impression_count\":\"6909\",\"revenue\":\"5.2310506020\"},{\"date\":\"2019-01-25\",\"impression_count\":\"6543\",\"revenue\":\"5.0380436640\"},{\"date\":\"2019-01-26\",\"impression_count\":\"6826\",\"revenue\":\"5.1506267240\"},{\"date\":\"2019-01-27\",\"impression_count\":\"6735\",\"revenue\":\"5.1431399690\"},{\"date\":\"2019-01-28\",\"impression_count\":\"6721\",\"revenue\":\"5.1469501770\"},{\"date\":\"2019-01-29\",\"impression_count\":\"6320\",\"revenue\":\"3.6648222930\"},{\"date\":\"2019-01-30\",\"impression_count\":\"4401\",\"revenue\":\"1.5135190250\"},{\"date\":\"2019-01-31\",\"impression_count\":\"4074\",\"revenue\":\"1.3023665130\"},{\"date\":\"2019-02-01\",\"impression_count\":\"3229\",\"revenue\":\"1.9801997000\"},{\"date\":\"2019-02-02\",\"impression_count\":\"2492\",\"revenue\":\"1.3688955000\"},{\"date\":\"2019-02-03\",\"impression_count\":\"1452\",\"revenue\":\"0.7825602000\"},{\"date\":\"2019-02-04\",\"impression_count\":\"2485\",\"revenue\":\"1.4903976220\"},{\"date\":\"2019-02-05\",\"impression_count\":\"1971\",\"revenue\":\"1.1495494090\"},{\"date\":\"2019-02-06\",\"impression_count\":\"1842\",\"revenue\":\"1.3404839840\"},{\"date\":\"2019-02-07\",\"impression_count\":\"2354\",\"revenue\":\"1.6575883320\"},{\"date\":\"2019-02-08\",\"impression_count\":\"2695\",\"revenue\":\"1.8173253960\"},{\"date\":\"2019-02-09\",\"impression_count\":\"5300\",\"revenue\":\"4.4098787140\"},{\"date\":\"2019-02-10\",\"impression_count\":\"2809\",\"revenue\":\"2.0628598500\"},{\"date\":\"2019-02-11\",\"impression_count\":\"4650\",\"revenue\":\"4.3570416300\"},{\"date\":\"2019-02-12\",\"impression_count\":\"2137\",\"revenue\":\"1.3153558430\"},{\"date\":\"2019-02-13\",\"impression_count\":\"2248\",\"revenue\":\"1.1267229520\"},{\"date\":\"2019-02-14\",\"impression_count\":\"5335\",\"revenue\":\"2.6894874460\"},{\"date\":\"2019-02-15\",\"impression_count\":\"2029\",\"revenue\":\"1.5797093870\"},{\"date\":\"2019-02-16\",\"impression_count\":\"274\",\"revenue\":\"0.2784520940\"},{\"date\":\"2019-02-17\",\"impression_count\":\"247\",\"revenue\":\"0.2480342720\"},{\"date\":\"2019-02-18\",\"impression_count\":\"269\",\"revenue\":\"0.2694215610\"},{\"date\":\"2019-02-19\",\"impression_count\":\"244\",\"revenue\":\"0.2562165170\"},{\"date\":\"2019-02-20\",\"impression_count\":\"232\",\"revenue\":\"0.2341013130\"},{\"date\":\"2019-02-21\",\"impression_count\":\"146\",\"revenue\":\"0.1475196550\"},{\"date\":\"2019-02-22\",\"impression_count\":\"126\",\"revenue\":\"0.1310243980\"},{\"date\":\"2019-02-23\",\"impression_count\":\"134\",\"revenue\":\"0.1347990010\"},{\"date\":\"2019-02-24\",\"impression_count\":\"175\",\"revenue\":\"0.1723614580\"},{\"date\":\"2019-02-25\",\"impression_count\":\"220\",\"revenue\":\"0.2213174420\"},{\"date\":\"2019-02-26\",\"impression_count\":\"166\",\"revenue\":\"0.1727305470\"},{\"date\":\"2019-02-27\",\"impression_count\":\"195\",\"revenue\":\"0.2009306610\"},{\"date\":\"2019-02-28\",\"impression_count\":\"208\",\"revenue\":\"0.2137215330\"},{\"date\":\"2019-03-01\",\"impression_count\":\"312\",\"revenue\":\"0.3149063000\"},{\"date\":\"2019-03-02\",\"impression_count\":\"322\",\"revenue\":\"0.3310149320\"},{\"date\":\"2019-03-03\",\"impression_count\":\"305\",\"revenue\":\"0.3083399850\"},{\"date\":\"2019-03-04\",\"impression_count\":\"257\",\"revenue\":\"0.2548512900\"},{\"date\":\"2019-03-05\",\"impression_count\":\"200\",\"revenue\":\"0.2072367180\"},{\"date\":\"2019-03-06\",\"impression_count\":\"233\",\"revenue\":\"0.2459042420\"},{\"date\":\"2019-03-07\",\"impression_count\":\"319\",\"revenue\":\"0.3362658550\"},{\"date\":\"2019-03-08\",\"impression_count\":\"382\",\"revenue\":\"0.4053247150\"},{\"date\":\"2019-03-09\",\"impression_count\":\"453\",\"revenue\":\"0.4885210780\"},{\"date\":\"2019-03-10\",\"impression_count\":\"438\",\"revenue\":\"0.4708203750\"},{\"date\":\"2019-03-11\",\"impression_count\":\"320\",\"revenue\":\"0.3343919080\"},{\"date\":\"2019-03-12\",\"impression_count\":\"365\",\"revenue\":\"0.3958568020\"},{\"date\":\"2019-03-13\",\"impression_count\":\"118\",\"revenue\":\"0.1258337070\"}],\"message\":\"Success\",\"status\":200}";
    }

    @PostMapping("/test")
    @ResponseBody
    public ResponseEntity test(HttpServletRequest request) throws IOException {
        JsonNode jsonNode = objectMapper.readTree(request.getInputStream());
        System.out.println(jsonNode.toString());
        return ResponseEntity.ok("{\n" +
                "    \"id\": \"B93F3DF68A816CECC8EF191921E9F27F\",\n" +
                "    \"seatbid\": [\n" +
                "        {\n" +
                "            \"bid\": [\n" +
                "                {\n" +
                "                    \"id\": \"67091302904369152\",\n" +
                "                    \"impid\": \"1\",\n" +
                "                    \"price\": 0.8,\n" +
                "                    \"nurl\": \"http://192.168.2.114:8101/win/mobfox?dealprc=${AUCTION_PRICE}&bidid=67091302904369152&reqid=B93F3DF68A816CECC8EF191921E9F27F&ids=7LIXsGzKeQzBSwz9ARaNsrN7IAESVxlZVrgFjX%2F6sk1jxiG8ZMISM%2BaEv2jcJgCARQNUoRPDfY%2BYt%2F6G%2F%2Fv3J%2FPaVX%2FZ8t4cQ94tDwlLm3rSJlXUdZPMqVkC6H9ou3LVhli9GOWAgFNHkfyFQoQidfA7jcRqQPz0P2NrF61fCYdf9GwO7M%2FB8CvrsfgyZ%2Fc4X%2BPgYXbUOpluTKZNyQQ%2BOlkFWhFuhl7xqyNI81k0Ey6%2FmHIqP1E4NgugNICAUgREL53eYzjUhIWWTVRly2vPPwWVLDVVZWVL%2FJfrmt2Cprmv6k07GtOAw%2FJhFlOIxVPsCuPsfypykXyE1WFibyNhwLs5Nuek%2FvZxnVW43mmyG%2BXPNv%2BzL1h1%2Bd4jd2fI71%2BBBykonbabif%2FCKciFXHXdLMaTxI9XlYf9DH37gWU9sHjPIjgwRwzQ07eTEHlytBw90EaV5KORZ3KRpP5O4l4EzNelo%2BDtc8LnqDweMXfGgzSAyUDDB1sp0dbC7j0RlwQfJ9t2ZJenUg9fB37%2BqeqOb7Nw4dKofe9hD%2FrYxF1uQ%2F18Rv7yQ7ZFn92N4jW9tvyouSvkUKa0XJwXIQTIPw4nPwQ9aKGHj39nPfWxTH3HlXo\",\n" +
                "                    \"adm\": \"<a href=\\\"http://127.0.0.1:8080/tracking/click/banner?bi=7LIXsGzKeQzBSwz9ARaNsrN7IAESVxlZVrgFjX%2F6sk1jxiG8ZMISM%2BaEv2jcJgCARQNUoRPDfY%2BYt%2F6G%2F%2Fv3J%2FPaVX%2FZ8t4cQ94tDwlLm3rSJlXUdZPMqVkC6H9ou3LVhli9GOWAgFNHkfyFQoQidfA7jcRqQPz0P2NrF61fCYdf9GwO7M%2FB8CvrsfgyZ%2Fc4X%2BPgYXbUOpluTKZNyQQ%2BOlkFWhFuhl7xqyNI81k0Ey6%2FmHIqP1E4NgugNICAUgREL53eYzjUhIWWTVRly2vPPwWVLDVVZWVL%2FJfrmt2Cprmv6k07GtOAw%2FJhFlOIxVPsCuPsfypykXyE1WFibyNhwLs5Nuek%2FvZxnVW43mmyG%2BXPNv%2BzL1h1%2Bd4jd2fI71%2BBBykonbabif%2FCKciFXHXdLMaTxI9XlYf9DH37gWU9sHjPIjgwRwzQ07eTEHlytBw90EaV5KORZ3KRpP5O4l4EzNelo%2BDtc8LnqDweMXfGgzSAyUDDB1sp0dbC7j0RlwQfJ9t2ZJenUg9fB37%2BqeqOb7Nw4dKofe9hD%2FrYxF1uQ%2F18Rv7yQ7ZFn92N4jW9tvyouSvkUKa0XJwXIQTIPw4nPwQ9aKGHj39nPfWxTH3HlXo\\\"><img src=\\\"https://img.myrtbcdn.com/2b1cf67e384efc830256b746064470b76f2444e8b432af67aea48d1d345aff45.gif\\\"/></a><img src=\\\"http://127.0.0.1:8080/tracking/imp?bi=7LIXsGzKeQzBSwz9ARaNsrN7IAESVxlZVrgFjX%2F6sk1jxiG8ZMISM%2BaEv2jcJgCARQNUoRPDfY%2BYt%2F6G%2F%2Fv3J%2FPaVX%2FZ8t4cQ94tDwlLm3rSJlXUdZPMqVkC6H9ou3LVhli9GOWAgFNHkfyFQoQidfA7jcRqQPz0P2NrF61fCYdf9GwO7M%2FB8CvrsfgyZ%2Fc4X%2BPgYXbUOpluTKZNyQQ%2BOlkFWhFuhl7xqyNI81k0Ey6%2FmHIqP1E4NgugNICAUgREL53eYzjUhIWWTVRly2vPPwWVLDVVZWVL%2FJfrmt2Cprmv6k07GtOAw%2FJhFlOIxVPsCuPsfypykXyE1WFibyNhwLs5Nuek%2FvZxnVW43mmyG%2BXPNv%2BzL1h1%2Bd4jd2fI71%2BBBykonbabif%2FCKciFXHXdLMaTxI9XlYf9DH37gWU9sHjPIjgwRwzQ07eTEHlytBw90EaV5KORZ3KRpP5O4l4EzNelo%2BDtc8LnqDweMXfGgzSAyUDDB1sp0dbC7j0RlwQfJ9t2ZJenUg9fB37%2BqeqOb7Nw4dKofe9hD%2FrYxF1uQ%2F18Rv7yQ7ZFn92N4jW9tvyouSvkUKa0XJwXIQTIPw4nPwQ9aKGHj39nPfWxTH3HlXo\\\" style=\\\"display:none\\\"/><div><script>!function(e){var t=document.createElement(\\\"img\\\");t.src=e+(e.includes(\\\"?\\\")?\\\"&\\\":\\\"?\\\")+\\\"v=\\\"+document.visibilityState,t.style=\\\"width:1px;height:1px;display:none\\\",document.currentScript.parentElement.appendChild(t)}(\\\"http://127.0.0.1:8080/tracking/visible?bi=7LIXsGzKeQzBSwz9ARaNsrN7IAESVxlZVrgFjX%2F6sk1jxiG8ZMISM%2BaEv2jcJgCARQNUoRPDfY%2BYt%2F6G%2F%2Fv3J%2FPaVX%2FZ8t4cQ94tDwlLm3rSJlXUdZPMqVkC6H9ou3LVhli9GOWAgFNHkfyFQoQidfA7jcRqQPz0P2NrF61fCYdf9GwO7M%2FB8CvrsfgyZ%2Fc4X%2BPgYXbUOpluTKZNyQQ%2BOlkFWhFuhl7xqyNI81k0Ey6%2FmHIqP1E4NgugNICAUgREL53eYzjUhIWWTVRly2vPPwWVLDVVZWVL%2FJfrmt2Cprmv6k07GtOAw%2FJhFlOIxVPsCuPsfypykXyE1WFibyNhwLs5Nuek%2FvZxnVW43mmyG%2BXPNv%2BzL1h1%2Bd4jd2fI71%2BBBykonbabif%2FCKciFXHXdLMaTxI9XlYf9DH37gWU9sHjPIjgwRwzQ07eTEHlytBw90EaV5KORZ3KRpP5O4l4EzNelo%2BDtc8LnqDweMXfGgzSAyUDDB1sp0dbC7j0RlwQfJ9t2ZJenUg9fB37%2BqeqOb7Nw4dKofe9hD%2FrYxF1uQ%2F18Rv7yQ7ZFn92N4jW9tvyouSvkUKa0XJwXIQTIPw4nPwQ9aKGHj39nPfWxTH3HlXo\\\");</script></div>\",\n" +
                "                    \"adomain\": [\n" +
                "                        \"baidu.com\"\n" +
                "                    ],\n" +
                "                    \"iurl\": \"https://img.myrtbcdn.com/2b1cf67e384efc830256b746064470b76f2444e8b432af67aea48d1d345aff45.gif\",\n" +
                "                    \"cid\": \"7\",\n" +
                "                    \"crid\": \"444\",\n" +
                "                    \"h\": 50,\n" +
                "                    \"w\": 320\n" +
                "                }\n" +
                "            ],\n" +
                "            \"seat\": \"1\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"bidid\": \"67091302904369152\",\n" +
                "    \"cur\": \"USD\"\n" +
                "}");
    }
}
