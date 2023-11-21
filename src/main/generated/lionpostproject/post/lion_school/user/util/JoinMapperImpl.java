package lionpostproject.post.lion_school.user.util;

import java.time.LocalDate;
import javax.annotation.processing.Generated;
import lionpostproject.post.lion_school.user.application.reqeust.JoinRequest;
import lionpostproject.post.lion_school.user.dto.UserDTO;
import lionpostproject.post.lion_school.user.entity.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-21T13:18:48+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class JoinMapperImpl implements JoinMapper {

    @Override
    public User user(JoinRequest joinRequest) {
        if ( joinRequest == null ) {
            return null;
        }

        String name = null;
        String email = null;
        String password = null;
        LocalDate birthday = null;

        name = joinRequest.getName();
        email = joinRequest.getEmail();
        password = joinRequest.getPassword();
        birthday = joinRequest.getBirthday();

        Long authorId = null;

        User user = new User( authorId, name, email, password, birthday );

        return user;
    }

    @Override
    public UserDTO userDTO(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        Long authorId = null;
        String name = null;
        String email = null;
        String password = null;
        LocalDate birthday = null;

        UserDTO userDTO = new UserDTO( id, authorId, name, email, password, birthday );

        return userDTO;
    }
}
