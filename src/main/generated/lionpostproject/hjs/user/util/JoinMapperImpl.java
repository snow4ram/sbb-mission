package lionpostproject.hjs.user.util;

import java.time.LocalDate;
import javax.annotation.processing.Generated;
import lionpostproject.hjs.user.controller.reqeust.JoinRequest;
import lionpostproject.hjs.user.entity.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-27T10:29:37+0900",
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

        User user = new User( name, email, password, birthday );

        return user;
    }
}
