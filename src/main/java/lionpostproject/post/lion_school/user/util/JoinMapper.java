package lionpostproject.post.lion_school.user.util;


import lionpostproject.post.lion_school.user.application.reqeust.JoinRequest;
import lionpostproject.post.lion_school.user.dto.UserDTO;
import lionpostproject.post.lion_school.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface JoinMapper {

    JoinMapper INSTANCE = Mappers.getMapper(JoinMapper.class);

    User user(JoinRequest joinRequest);

    UserDTO userDTO(User user);
}
