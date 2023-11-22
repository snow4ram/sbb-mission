package lionpostproject.hjs.user.service.verification;

import lionpostproject.hjs.user.controller.reqeust.LoginRequest;
import lionpostproject.hjs.user.entity.User;
import lionpostproject.hjs.user.repostiory.JpaUserRepository;
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
