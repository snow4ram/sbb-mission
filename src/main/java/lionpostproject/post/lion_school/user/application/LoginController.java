package lionpostproject.post.lion_school.user.application;



import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lionpostproject.post.lion_school.user.application.reqeust.JoinRequest;
import lionpostproject.post.lion_school.user.application.reqeust.LoginRequest;
import lionpostproject.post.lion_school.user.application.response.LoginResponse;
import lionpostproject.post.lion_school.user.dto.UserDTO;
import lionpostproject.post.lion_school.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequiredArgsConstructor
public class LoginController {

    @Autowired
    private final UserService userService;


    @GetMapping("/main-page")
    public String mainPage() {
        return "main_page";
    }


    @GetMapping("/sign-up")
    public String signUpPage() {
        return "sign_up";
    }


    @PostMapping("/sign-up")
    public ResponseEntity<LoginResponse> signUpForm(@Validated @RequestBody final JoinRequest joinRequest , final HttpServletRequest servletRequest) {

        //servletRequest.getSession(false);

        UserDTO join = userService.join(joinRequest, servletRequest);

        LoginResponse loginResponse = new LoginResponse(join);

        //200
        return ResponseEntity.ok().body(loginResponse);
    }


    @GetMapping("/login")
    public String home(HttpServletRequest servletRequest) {
        servletRequest.getSession(false);
        return "home";
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginForm(@Validated @RequestBody final LoginRequest loginRequest , final HttpSession session) {

        UserDTO login = userService.login(loginRequest, session);

        LoginResponse loginResponse = new LoginResponse(login);

        return ResponseEntity.ok().body(loginResponse);
    }



    @PostMapping("/logout")
    public ResponseEntity<Void> logout(final HttpSession session) {

        userService.logout(session);

        return ResponseEntity.ok().build();
    }

}
