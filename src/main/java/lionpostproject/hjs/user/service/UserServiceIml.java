package lionpostproject.hjs.user.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lionpostproject.hjs.user.controller.reqeust.JoinRequest;
import lionpostproject.hjs.user.controller.reqeust.LoginRequest;
import lionpostproject.hjs.user.dto.UserDTO;
import lionpostproject.hjs.user.dto.UserDTOMapper;
import lionpostproject.hjs.user.entity.User;
import lionpostproject.hjs.user.repostiory.JpaUserRepository;
import lionpostproject.hjs.user.service.security.LoginSecurityService;
import lionpostproject.hjs.user.service.security.SignUpSecurityService;
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


    private final UserDTOMapper userDTOMapper;


    private final JoinMapper joinMapper;


    private final SignUpSecurityService signUpSecurityService;


    private final LoginSecurityService loginSecurityService;


    private static final String SESSION_KEY = "id";

    @Override
    public UserDTO join(JoinRequest joinRequest ,final HttpSession session) {

        //아이디 중복 검증
        boolean account = signUpSecurityService.checkForDuplicateUserId(joinRequest);


        if (account) {
            throw new RuntimeException("아이디가 중복 상태 입니다.");
        }

        User user = joinMapper.user(joinRequest);

        session.setAttribute(SESSION_KEY ,user.getEmail());

        jpaUserRepository.save(user);

        return userDTOMapper.apply(user);
    }

    @Override
    public UserDTO login(LoginRequest loginRequest,final HttpSession session) {

        User user = loginSecurityService.userValidateCredentials(loginRequest);
        if (user != null) {
            session.setAttribute(SESSION_KEY , user.getEmail());
        }else {
            throw new RuntimeException("사용자 의 정보가 없습니다.");
        }
        return userDTOMapper.apply(user);
    }

    @Override
    public void logout(HttpSession session) {

    }
}
