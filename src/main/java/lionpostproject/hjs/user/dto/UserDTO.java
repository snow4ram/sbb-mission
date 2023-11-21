package lionpostproject.hjs.user.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public record UserDTO(

        Long id,
        Long authorId,

        String name,
        String email,
        String password,

        LocalDate birthday

) {
}
