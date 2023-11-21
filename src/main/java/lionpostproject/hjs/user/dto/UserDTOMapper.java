package lionpostproject.hjs.user.dto;

import lionpostproject.hjs.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDTOMapper implements Function<User, UserDTO> {
    @Override
    public UserDTO apply(User user) {
        return new UserDTO(
                user.getId(),
                user.getAuthorId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getBirthday()
        );
    }
}
