package lionpostproject.hjs.user;

import lionpostproject.hjs.user.controller.reqeust.JoinRequest;
import lionpostproject.hjs.user.controller.reqeust.LoginRequest;
import lionpostproject.hjs.user.dto.UserDTO;
import lionpostproject.hjs.user.entity.User;
import lionpostproject.hjs.user.repostiory.JpaUserRepository;
import lionpostproject.hjs.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class UserServiceTest {


    @Autowired
    UserService users;

    @InjectMocks
    MockHttpSession session;

    @Autowired
    JpaUserRepository userRepository;

    @BeforeEach
    public void init() {

        userRepository.save(new User("user A" , "xxx7949@naver.com", "aaa" , LocalDate.now()));
    }



    @Test
    public void join() {

        //give
        JoinRequest request = new JoinRequest("user A" , "ooo7949@naver.com", "aaa" , LocalDate.now());


        //when
        UserDTO join = users.join(request, session);


        //then
        assertThat(join.getEmail()).isEqualTo(request.getEmail());
    }


    @Test
    public void login() {

        //give
        LoginRequest loginRequest = new LoginRequest("xxx7949@naver.com", "aaa" );


        //when
        UserDTO login = users.login(loginRequest, session);


        //then
        assertThat(login.getEmail()).isEqualTo(loginRequest.getEmail());


    }



    @AfterEach
    public void clear() {
        userRepository.deleteAll();
    }
}
