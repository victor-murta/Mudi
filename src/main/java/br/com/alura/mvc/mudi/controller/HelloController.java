package br.com.alura.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    //hello == action (método de classes controllers; o retorno dela é o nome da view que será executada)
    @GetMapping("/hello")
    public String hello(HttpServletRequest request){
        request.setAttribute("nome", "Mundo");
        return "hello";
    }

}
