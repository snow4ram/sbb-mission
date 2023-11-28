package lionpostproject.hjs.user.service;

import jakarta.servlet.http.HttpSession;
import lionpostproject.hjs.user.controller.reqeust.JoinRequest;
import lionpostproject.hjs.user.controller.reqeust.LoginRequest;
import lionpostproject.hjs.user.dto.UserDTO;
import lionpostproject.hjs.user.entity.User;
import lionpostproject.hjs.user.repostiory.JpaUserRepository;
import lionpostproject.hjs.user.service.verification.LoginSecurityService;
import lionpostproject.hjs.user.service.verification.SignUpSecurityService;
import lionpostproject.hjs.user.util.JoinMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceIml implements UserService {


    private final JpaUserRepository jpaUserRepository;

    private final JoinMapper mappers;

    private final SignUpSecurityService signUpSecurityService;

    private final LoginSecurityService loginSecurityService;

    public static final String SESSION_KEY = "id";

    @Override
    public UserDTO join(JoinRequest joinRequest ,final HttpSession session) {

        signUpSecurityService.checkForDuplicateUserId(joinRequest.getEmail());

        User user = mappers.user(joinRequest);


        session.setAttribute(SESSION_KEY ,user.getEmail());

        jpaUserRepository.save(user);

        return mappers.userDTO(user);
    }

    @Override
    public UserDTO login(LoginRequest loginRequest , final HttpSession session) {

        User user = loginSecurityService.userValidateCredentials(loginRequest);

        if (user != null) {
            session.setAttribute(SESSION_KEY , user.getEmail());
        }else {
            throw new RuntimeException("사용자 의 정보가 없습니다.");
        }
        return  mappers.userDTO(user);
    }

    @Override
    public void logout(HttpSession session) {
        session.removeAttribute(SESSION_KEY);
    }




}
