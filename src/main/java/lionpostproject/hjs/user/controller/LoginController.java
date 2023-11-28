package lionpostproject.hjs.user.controller;



import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lionpostproject.hjs.user.controller.reqeust.JoinRequest;
import lionpostproject.hjs.user.controller.reqeust.LoginRequest;
import lionpostproject.hjs.user.controller.response.LoginResponse;
import lionpostproject.hjs.user.dto.UserDTO;
import lionpostproject.hjs.user.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;


    @GetMapping("/join")
    public String signUpPage() {
        return "/membership/join";
    }


    @PostMapping("/join")
    public ResponseEntity<LoginResponse> signUpForm(@Validated @RequestBody final JoinRequest joinRequest ,final HttpSession session) {

        UserDTO join = userService.join(joinRequest, session);

        LoginResponse loginResponse = new LoginResponse(join);

        //200
        return ResponseEntity.ok().body(loginResponse);
    }


    @GetMapping("/login")
    public String home(HttpServletRequest servletRequest) {
        servletRequest.getSession(false);
        return "membership/login";
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginForm(@RequestBody final LoginRequest loginRequest ,final HttpSession session) {

        UserDTO login = userService.login(loginRequest, session);

        LoginResponse loginResponse = new LoginResponse(login);

        return ResponseEntity.ok().body(loginResponse);

    }


    @GetMapping("/logout")
    public String logout(final HttpSession session) {

        userService.logout(session);

        return "redirect:/login";
    }


}
