package com.fyj.imgtoword.service;

import com.baidu.aip.ocr.AipOcr;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author fanyongju
 * @Title: ImgToWordService
 * @Description: TODO
 * @date 2018/9/1014:26
 */
@Service
public class ImgToWordService {
    private static AipOcr client;
    private static HashMap<String, String> options;

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
    @PostConstruct
    private void initAipOcr() {
        client = new AipOcr("11935153", "mKYoPpsdCb5NqLw2XInE7QR9", "nvT8IL7F7oQgqqmZ5XrOhks0XXFtHeto");
        options = new HashMap<>(4);
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");
    }

    public String imgToWord(byte[] image) throws IOException {
        JSONObject res = client.basicAccurateGeneral(image, options);
        JsonNode wordsResult = objectMapper.readTree(res.toString()).get("words_result");
        StringBuilder words = new StringBuilder();
        for(JsonNode wordNode : wordsResult){
            words.append(wordNode.get("words").asText());
        }
        return words.toString();
    }
}
