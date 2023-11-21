package lionpostproject.post.lion_school.user.service.security;

import lionpostproject.post.lion_school.user.application.reqeust.JoinRequest;
import lionpostproject.post.lion_school.user.repostiory.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Matcher;

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
