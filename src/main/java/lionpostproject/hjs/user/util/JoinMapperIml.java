package lionpostproject.hjs.user.util;

import lionpostproject.hjs.user.entity.User;
import lionpostproject.hjs.user.controller.reqeust.JoinRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

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

}
