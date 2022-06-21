package br.com.antares.cadastroapi.controller;

import br.com.antares.cadastroapi.dto.LoginDTO;
import br.com.antares.cadastroapi.service.LoginService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/registration/login")
public class LoginController {

    private final LoginService loginService;

    LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping("/passwordValidate")
    @ApiOperation(value = "Valida e-mail e senha de acesso do usuário")
    public ResponseEntity<Boolean> passwordValidate(@RequestBody LoginDTO loginDTO){
        return loginService.passwordValidade(loginDTO);
    }
}
