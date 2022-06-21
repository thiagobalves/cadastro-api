package br.com.antares.cadastroapi.controller;

import br.com.antares.cadastroapi.dto.UserDTO;
import br.com.antares.cadastroapi.model.User;
import br.com.antares.cadastroapi.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/registration/user")
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

    @PostMapping("/postNewUser")
    @ApiOperation(value = "Insere novo usuário na base de dados")
    public ResponseEntity<UserDTO> createNewUser(@RequestBody User user){
        return new ResponseEntity<>(this.userService.createNewUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/updateUserById/{id}")
    @ApiOperation(value = "Atualiza dados de usuário cadastrado")
    public UserDTO updateUserById(@PathVariable Integer id, @RequestBody User user){
        return userService.updateUserById(id, user);
    }

    @DeleteMapping("/deleteUserById/{id}")
    @ApiOperation(value = "Deleta dados de usuário")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        return userService.deleteUserById(id);
    }
}
