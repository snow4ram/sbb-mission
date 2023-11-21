package lionpostproject.post.user;


import lionpostproject.hjs.user.controller.reqeust.JoinRequest;
import lionpostproject.hjs.user.dto.UserDTO;
import lionpostproject.hjs.user.entity.User;
import lionpostproject.hjs.user.repostiory.JpaUserRepository;
import lionpostproject.hjs.user.util.JoinMapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@Slf4j
@SpringBootTest
public class JoinMapperTest {

    @Autowired
    JoinMapper joinMapper;

    @Autowired
    JpaUserRepository userRepository;

    @BeforeEach
    void user_create() {
        userRepository.save(new User(
                1L,
                "testName",
                "test email",
                "test password",
                LocalDate.of(1998, 11, 13)
        ));
    }

    @Test
    @DisplayName("사용자로부터 JoinRequest 요청이 올 경우 User로 반환")
    public void join() {

        //give
        JoinRequest request1 = new JoinRequest(
                "test ",
                "test email",
                "test password ",
                LocalDate.of(1998, 11, 13)
        );

        //when
        User user = joinMapper.user(request1);

        //then
        log.info(user.toString());

        Assertions.assertThat(user).isNotNull();

        Assertions.assertThat(user.getEmail()).isEqualTo(request1.getEmail());

    }


    @Test
    @DisplayName("사용자로부터 User 값을 UserDTO 반환 ")
    public void joinUser() {

        User user = userRepository.findById(1L).orElseThrow();

        UserDTO userDTO = joinMapper.userDTO(user);

        Assertions.assertThat(user.getName()).isEqualTo(userDTO.name());

        Assertions.assertThat(userDTO.id()).isEqualTo(1L);
    }


    @AfterEach
    void deleteAll() {
        userRepository.deleteAll();
    }


}
