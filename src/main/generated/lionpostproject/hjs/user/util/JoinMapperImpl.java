package lionpostproject.hjs.user.util;

import java.time.LocalDate;
import javax.annotation.processing.Generated;
import lionpostproject.hjs.user.controller.reqeust.JoinRequest;
import lionpostproject.hjs.user.dto.UserDTO;
import lionpostproject.hjs.user.entity.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-28T15:24:15+0900",
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

        User user = new User( name, email, password, birthday );

        return user;
    }

    @Override
    public UserDTO userDTO(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String email = null;
        String password = null;
        LocalDate birthday = null;

        UserDTO userDTO = new UserDTO( id, name, email, password, birthday );

        return userDTO;
    }
}
