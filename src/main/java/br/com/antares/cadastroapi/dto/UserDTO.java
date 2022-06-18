package br.com.antares.cadastroapi.dto;

import br.com.antares.cadastroapi.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Integer id;
    private String  name;
    private String  email;

    public UserDTO(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
    }

    public static List<UserDTO> convert(List<User> users) {
        return users.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    //TODO REFATORA USO DO OPCIONAL COMO PARAMETRO E ADD IFPRESENT
    public static Optional<UserDTO> returnUserDTO(Optional<User> user){
        try {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.get().getId());
            userDTO.setName(user.get().getName());
            userDTO.setEmail(user.get().getEmail());

            return Optional.of(userDTO);
        } catch(Exception e){
            throw new RuntimeException("Usuário não encontrado " + e);
        }
    }
}
