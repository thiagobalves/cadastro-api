package br.com.antares.cadastroapi.service;

import br.com.antares.cadastroapi.dto.LoginDTO;
import br.com.antares.cadastroapi.model.User;
import br.com.antares.cadastroapi.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    LoginService(UserRepository repository, PasswordEncoder encoder){
        this.repository = repository;
        this.encoder = encoder;
    }

    public ResponseEntity<Boolean> passwordValidade(LoginDTO loginDTO) {
        Optional<User> optUser = repository.findByEmail(loginDTO.getEmail());

        if(optUser.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        User user = optUser.get();
        Boolean validPassword = encoder.matches(loginDTO.getPassword(), user.getPassword());

        HttpStatus status = (validPassword) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(validPassword);
    }
}
