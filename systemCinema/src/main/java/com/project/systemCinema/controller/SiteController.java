package com.project.systemCinema.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

// CLASSE PARA GERENCIAMENTO DE COOKIES DO SITE
@Controller 
public class SiteController {
   
    // Método para salvar cookie com tema 
    @PostMapping("/MudancaTema")
    @ResponseBody
    public String MudancaTema(@RequestBody String tema, HttpServletResponse response) {
        System.out.println(tema + " SiteController");
        String temaTratado = tema.replace("\"", "");
        System.out.println(temaTratado + " tema sem aspas");
        
        Cookie cookieTema = new Cookie("tema", temaTratado);
        cookieTema.setDomain("localhost");             
        cookieTema.setMaxAge(86400); // 1 dia 
        response.addCookie(cookieTema);
        
        return "Tema alterado para: " + tema;
    }
}
