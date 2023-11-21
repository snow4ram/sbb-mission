package lionpostproject.hjs.user.service.security;

import lionpostproject.hjs.user.controller.reqeust.JoinRequest;
import lionpostproject.hjs.user.repostiory.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignUpSecurityService {

    @Autowired
    private final JpaUserRepository jpaUserRepository;

    @Transactional(readOnly = true)
    public boolean checkForDuplicateUserId(final JoinRequest joinRequest) {

        return jpaUserRepository.findByEmail(joinRequest.getEmail())
                .stream()
                .anyMatch(duplicateUserId ->
                        duplicateUserId.getEmail().equals(joinRequest.getEmail()));
    }


    //회원 가입시 비밀 번호 정규 표현식 으로 양식 체크


}
