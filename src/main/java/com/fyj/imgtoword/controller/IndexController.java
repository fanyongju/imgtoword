package com.fyj.imgtoword.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * @author fanyongju
 * @Title: IndexController
 * @Description: TODO
 * @date 2018/9/1415:14
 */
@Controller
public class IndexController {
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
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

    public static void main(String[] args) {
        System.out.println("fyj");
    }
}
