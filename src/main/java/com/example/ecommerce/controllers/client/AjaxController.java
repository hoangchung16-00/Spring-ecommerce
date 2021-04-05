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
    public @ResponseBody String getSizeAttribute(@RequestParam("idproductattribute") Long sizeId, HttpSession session){
        session.setAttribute("size",sizeId);
        ObjectMapper mapper = new ObjectMapper();
        String ajaxResponse = "";
        try {
            ajaxResponse = mapper.writeValueAsString(sizeId);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ajaxResponse;
    }
    @GetMapping("/chooseColor")
    public @ResponseBody String getColorAttribute(@RequestParam("idproductattribute") Long colorId, HttpSession session){
        session.setAttribute("color",colorId);
        ObjectMapper mapper = new ObjectMapper();
        String ajaxResponse = "";
        try {
            ajaxResponse = mapper.writeValueAsString(colorId);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ajaxResponse;
    }
}
