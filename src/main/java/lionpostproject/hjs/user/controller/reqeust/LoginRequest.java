package lionpostproject.hjs.user.controller.reqeust;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class LoginRequest {

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;


    public LoginRequest( final String email, final String password) {

        this.email = email;
        this.password = password;
    }
}
