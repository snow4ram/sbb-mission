package lionpostproject.post.lion_school.user.service.security;

import lionpostproject.post.lion_school.user.application.reqeust.LoginRequest;
import lionpostproject.post.lion_school.user.entity.User;
import lionpostproject.post.lion_school.user.repostiory.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginSecurityService {

    @Autowired
    private final JpaUserRepository jpaUserRepository;

    @Transactional(readOnly = true)
    public User userValidateCredentials(final LoginRequest request) {

        return jpaUserRepository.findByEmailAndPassword(request.getEmail() , request.getPassword())
                .stream()
                .filter(u -> {
                    if (u.getEmail().equals(request.getEmail())) {
                        return true;
                    }
                    return u.getPassword().equals(request.getPassword());
                })
                .findFirst().orElseThrow(() -> new RuntimeException("사용자의 정보가 없습니다."));
    }


}
