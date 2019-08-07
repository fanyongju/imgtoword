package com.fyj.imgtoword.controller;

import com.fyj.imgtoword.service.ImgToWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

/**
 * @author fanyongju
 * @Title: ImgToWordController
 * @Description: TODO
 * @date 2018/9/1014:21
 */
@Controller
public class ProcessController {
    @Autowired
    private ImgToWordService imgToWordService;

    @RequestMapping(value = "imgtoword", method = RequestMethod.POST)
    public String index(@RequestParam("file") MultipartFile file,Model model) throws IOException {
        byte[] image = file.getBytes();
        String result = null;
        try {
            result = imgToWordService.imgToWord(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("result",result);
        return "imgtoword/out";
    }
}
