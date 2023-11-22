package lionpostproject.hjs.user.util;

import javax.annotation.processing.Generated;
import lionpostproject.hjs.user.controller.reqeust.JoinRequest;
import lionpostproject.hjs.user.entity.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-22T17:34:18+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class JoinMapperImpl implements JoinMapper {

    @Override
    public User user(JoinRequest joinRequest) {
        if ( joinRequest == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.name( joinRequest.getName() );
        user.email( joinRequest.getEmail() );
        user.password( joinRequest.getPassword() );
        user.birthday( joinRequest.getBirthday() );

        return user.build();
    }
}
