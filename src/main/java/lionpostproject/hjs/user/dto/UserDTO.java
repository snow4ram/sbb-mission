package lionpostproject.hjs.user.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private  String password;
    private LocalDate birthday;

    @Builder
    public UserDTO(Long id, String name, String email, String password, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
    }
}
