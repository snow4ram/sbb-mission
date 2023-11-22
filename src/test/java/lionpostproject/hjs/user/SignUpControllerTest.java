package lionpostproject.hjs.user;

import ch.qos.logback.core.spi.ErrorCodes;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import lionpostproject.hjs.user.controller.LoginController;
import lionpostproject.hjs.user.controller.reqeust.JoinRequest;
import lionpostproject.hjs.user.controller.reqeust.LoginRequest;
import lionpostproject.hjs.user.dto.UserDTO;
import lionpostproject.hjs.user.entity.User;
import lionpostproject.hjs.user.repostiory.JpaUserRepository;
import lionpostproject.hjs.user.service.UserService;
import lionpostproject.hjs.user.service.UserServiceIml;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.Mapper;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class SignUpControllerTest {

    @Autowired
    UserService users;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    JpaUserRepository jpaUserRepository;




    @BeforeEach
    public void init() {
        jpaUserRepository.save(new User(1L, "admin", "hjs7949@naver.com", "admin", LocalDate.now()));
    }


    @Test
    public void joinRe() {

        MockHttpSession session = new MockHttpSession();

        UserDTO join = users.join(new JoinRequest(
                "admin",
                "hjs7949@naver.com",
                "admin",
                LocalDate.now()
        ), session);

        User user = jpaUserRepository.findById(1L).orElseThrow();

        Assertions.assertThat(user.getEmail()).isEqualTo(join.email());
    }


    @Test
    @DisplayName("Join POST API 요청 회원가입 ")
    public void join() throws Exception {

        JoinRequest joinRequest = new JoinRequest(
                "test name",
                "test email",
                "test password",
                LocalDate.now()
        );

        mvc.perform(post("/join")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(joinRequest))
                )
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())  // 예시로, id 필드가 존재하는지 검증
                .andExpect(jsonPath("$.authorId").exists())
                .andExpect(jsonPath("$.name").value("test name"))
                .andExpect(jsonPath("$.email").value("test email"))
                .andExpect(jsonPath("$.password").value("test password"))
                .andExpect(jsonPath("$.birthday").value("2023-11-22"));


    }


    @Test
    @DisplayName("Join POST API 요청 회원가입 ")
    public void nullInput() throws Exception {

        JoinRequest joinRequest = new JoinRequest(
                "asd",
                "hjs7949@naver.com",
                "asdads",
                LocalDate.now()
        );

        mvc.perform(post("/join")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(joinRequest))
                )
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())  // 예시로, id 필드가 존재하는지 검증
                .andExpect(jsonPath("$.authorId").exists());
//                .andExpect(jsonPath("$.name").value("test name"))
//                .andExpect(jsonPath("$.email").value("test email"))
//                .andExpect(jsonPath("$.password").value("test password"))
//                .andExpect(jsonPath("$.birthday").value("2023-11-22"));


    }





}
