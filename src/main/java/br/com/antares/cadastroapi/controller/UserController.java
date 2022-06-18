package br.com.antares.cadastroapi.controller;

import br.com.antares.cadastroapi.dto.UserDTO;
import br.com.antares.cadastroapi.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/registration/user")
public class UserController {

    private final UserService userService;
    UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/getAllUsers")
    @ApiOperation(value = "Retorna todos os usuário cadastrados")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUserById/{id}")
    @ApiOperation(value = "Retorna usuário por ID")
    public Optional<UserDTO> getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }
}
