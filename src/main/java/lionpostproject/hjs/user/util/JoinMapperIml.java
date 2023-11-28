package lionpostproject.hjs.user.util;

import lionpostproject.hjs.user.dto.UserDTO;
import lionpostproject.hjs.user.entity.User;
import lionpostproject.hjs.user.controller.reqeust.JoinRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class JoinMapperIml implements JoinMapper{

    @Override
    public User user(JoinRequest joinRequest) {

        try {
            return User.builder()
                    .name(joinRequest.getName())
                    .email(joinRequest.getEmail())
                    .password(joinRequest.getPassword())
                    .birthday(joinRequest.getBirthday())
                    .build();
        } catch (NullPointerException e) {
            throw new RuntimeException("사용자 정보를 찾을수없습니다");
        }
    }

    @Override
    public UserDTO userDTO(User user) {
        try {
            return UserDTO.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .birthday(user.getBirthday())
                    .build();
        } catch (NullPointerException e) {
            throw new RuntimeException("사용자 정보를 찾을수없습니다");
        }
    }

}
