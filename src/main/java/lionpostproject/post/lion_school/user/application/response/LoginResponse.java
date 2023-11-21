package lionpostproject.post.lion_school.user.application.response;

import jakarta.validation.constraints.NotEmpty;
import lionpostproject.post.lion_school.user.dto.UserDTO;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class LoginResponse {

    private final Long id;

    private final Long authorId;

    private final String name;

    private final String email;

    private final String password;

    private final LocalDate birthday;


    public LoginResponse(UserDTO userDTO) {
        this.id = userDTO.id();
        this.authorId = userDTO.authorId();
        this.name = userDTO.name();
        this.email = userDTO.email();
        this.password = userDTO.password();
        this.birthday = userDTO.birthday();
    }
}
