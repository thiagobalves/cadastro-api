package br.com.antares.cadastroapi.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    @ApiOperation(value = "Retorna mensagem hello world")
    public String helloWorld(){
        return "Hello World";
    }
}
