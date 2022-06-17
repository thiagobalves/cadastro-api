package br.com.antares.cadastroapi.controller;

import br.com.antares.cadastroapi.model.User;
import br.com.antares.cadastroapi.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/v1/registration/user")
public class UserController {
    private UserRepository repository;

    UserController(UserRepository userRepository){
        this.repository = userRepository;
    }

    @GetMapping("/getAllUsers")
    @ApiOperation(value = "Retorna todos os usuário cadastrados")
    public List<User> getAllUsers() {
        List<User> users = repository.findAll();
        return users;
    }
}
