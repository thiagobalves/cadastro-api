package br.com.antares.cadastroapi.service;

import br.com.antares.cadastroapi.dto.UserDTO;
import br.com.antares.cadastroapi.model.User;
import br.com.antares.cadastroapi.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    UserService(UserRepository repository, PasswordEncoder encoder){
        this.repository = repository;
        this.encoder = encoder;
    }

    public List<UserDTO> getAllUsers(){
        List<User> users = repository.findAll();
        return UserDTO.convert(users);
    }

    public Optional<UserDTO> getUserById(Integer id) {
        Optional<User> user = repository.findById(id);
        return UserDTO.returnUserDTO(user);
    }

    public UserDTO createNewUser(User user) {
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(encoder.encode(user.getPassword()));
        User usuarioSalvo = repository.save(newUser);
        return usuarioSalvo.getUserDTO();
    }

    public UserDTO updateUserById(Integer id, User user) {
        Optional<User> userFound = repository.findById(id);
        try {
            User userUpdated = userFound.get();
            userUpdated.setName(user.getName());
            userUpdated.setEmail(user.getEmail());
            userUpdated.setPassword(encoder.encode(user.getPassword()));
            repository.save(userUpdated);

            return userUpdated.getUserDTO();
        } catch (Exception e){
            throw new RuntimeException("Usuário não encontrado " + e);
        }
    }

    public ResponseEntity deleteUserById(Integer id) {
        return repository.findById(id)
            .map(user -> {
                repository.deleteById(id);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}
