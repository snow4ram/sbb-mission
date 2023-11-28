package lionpostproject.hjs.user.controller.response;

import lionpostproject.hjs.user.dto.UserDTO;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class LoginResponse {

    private final Long id;

    private final String name;

    private final String email;

    private final String password;

    private final LocalDate birthday;


    public LoginResponse(UserDTO userDTO) {
        this.id = userDTO.getId();
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
        this.birthday = userDTO.getBirthday();
    }
}
