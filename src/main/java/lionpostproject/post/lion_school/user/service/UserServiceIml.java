package lionpostproject.post.lion_school.user.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lionpostproject.post.lion_school.user.application.reqeust.JoinRequest;
import lionpostproject.post.lion_school.user.application.reqeust.LoginRequest;
import lionpostproject.post.lion_school.user.dto.UserDTO;
import lionpostproject.post.lion_school.user.dto.UserDTOMapper;
import lionpostproject.post.lion_school.user.entity.User;
import lionpostproject.post.lion_school.user.repostiory.JpaUserRepository;
import lionpostproject.post.lion_school.user.service.security.LoginSecurityService;
import lionpostproject.post.lion_school.user.service.security.SignUpSecurityService;
import lionpostproject.post.lion_school.user.util.JoinMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceIml implements UserService {

    @Autowired
    private final JpaUserRepository jpaUserRepository;

    @Autowired
    private final UserDTOMapper userDTOMapper;

    @Autowired
    private final JoinMapper joinMapper;

    @Autowired
    private final SignUpSecurityService signUpSecurityService;

    @Autowired
    private final LoginSecurityService loginSecurityService;

    @Override
    public UserDTO join(JoinRequest joinRequest ,final HttpServletRequest servletRequest) {

        boolean account = signUpSecurityService.checkForDuplicateUserId(joinRequest);

        if (account) {
            throw new RuntimeException("아이디가 중복 상태 입니다.");
        }
        User user = joinMapper.user(joinRequest);

        jpaUserRepository.save(user);

        return userDTOMapper.apply(user);
    }

    @Override
    public UserDTO login(LoginRequest loginRequest, HttpSession session) {

        User user = loginSecurityService.userValidateCredentials(loginRequest);
        return userDTOMapper.apply(user);
    }

    @Override
    public void logout(HttpSession session) {

    }
}
