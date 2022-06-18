package br.com.antares.cadastroapi.service;

import br.com.antares.cadastroapi.dto.UserDTO;
import br.com.antares.cadastroapi.model.User;
import br.com.antares.cadastroapi.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    UserService(UserRepository repository){
        this.repository = repository;
    }

    public List<UserDTO> getAllUsers(){
        List<User> users = repository.findAll();
        return UserDTO.convert(users);
    }

    public Optional<UserDTO> getUserById(Integer id) {
        Optional<User> user = repository.findById(id);
        return UserDTO.returnUserDTO(user);
    }
}
