package com.example.ecommerce.controllers.client;

import com.example.ecommerce.entitys.ProductAttributes;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class AjaxController extends BaseExtender{
    @GetMapping("/chooseSize")
    public @ResponseBody String getSizeAttribute(@RequestParam("value") String sizeValue, HttpSession session){
        session.setAttribute("size",sizeValue);
        ObjectMapper mapper = new ObjectMapper();
        String ajaxResponse = "";
        try {
            ajaxResponse = mapper.writeValueAsString(sizeValue);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ajaxResponse;
    }
    @GetMapping("/chooseColor")
    public @ResponseBody String getColorAttribute(@RequestParam("value") String colorValue, HttpSession session){
        session.setAttribute("color",colorValue);
        ObjectMapper mapper = new ObjectMapper();
        String ajaxResponse = "";
        try {
            ajaxResponse = mapper.writeValueAsString(colorValue);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ajaxResponse;
    }
}
