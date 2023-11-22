package lionpostproject.hjs.user.util;


import lionpostproject.hjs.user.entity.User;
import lionpostproject.hjs.user.controller.reqeust.JoinRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface JoinMapper {

    JoinMapper INSTANCE = Mappers.getMapper(JoinMapper.class);

    User user(JoinRequest joinRequest);



}
