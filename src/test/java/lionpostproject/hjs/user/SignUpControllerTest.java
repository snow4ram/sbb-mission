package lionpostproject.hjs.user;

import com.fasterxml.jackson.databind.ObjectMapper;

import lionpostproject.hjs.user.controller.LoginController;
import lionpostproject.hjs.user.controller.reqeust.JoinRequest;

import lionpostproject.hjs.user.controller.reqeust.LoginRequest;
import lionpostproject.hjs.user.entity.User;
import lionpostproject.hjs.user.repostiory.JpaUserRepository;
import lionpostproject.hjs.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

    @InjectMocks
    MockHttpSession session;

    @BeforeEach
    public void init() {
        JoinRequest joinRequest = new JoinRequest(
                "userA",
                "xxx7949@naver.com",
                "test123",
                LocalDate.now()
        );


        users.join(joinRequest , session);
    }


    @Test
    @DisplayName("로그인 [POST] API 요청")
    public void join() throws Exception {

        LoginRequest login = new LoginRequest(
                "xxx7949@naver.com",
                "test123"
        );


        mvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(login))
                )
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.password").value("test123"))
                .andExpect(jsonPath("$.email").value("xxx7949@naver.com"))
                .andDo(print());

    }

    @Test
    @DisplayName("회원가입 [POST] API 요청")
    public void signUp() throws Exception {


        JoinRequest joinRequest = new JoinRequest(
                "userA",
                "xxxOOO@naver.com",
                "123456",
                LocalDate.now()
        );

        mvc.perform(post("/join")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(joinRequest))
                )
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())  // 예시로, id 필드가 존재하는지 검증
                .andExpect((handler().handlerType(LoginController.class)))
                .andExpect(jsonPath("$.name").value("userA"))
                .andExpect(jsonPath("$.email").value("xxxOOO@naver.com"))
                .andExpect(jsonPath("$.password").value("123456"))
                .andExpect(jsonPath("$.birthday").value("2023-11-27"))
                .andDo(print());
    }


    @Test
    @DisplayName("로그인 요청 후 Post 페이지 확인 ")
    public void loginPostPage() throws Exception {

        LoginRequest login = new LoginRequest(
                "xxx7949@naver.com",
                "test123"
        );

        mvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(login))
                )
                .andExpect(status().is2xxSuccessful())
                .andDo(print());
    }




    @AfterEach
    public void deleteAll() {
        jpaUserRepository.deleteAll();
    }
}
