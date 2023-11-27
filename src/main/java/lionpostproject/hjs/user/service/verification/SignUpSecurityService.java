package lionpostproject.hjs.user.service.verification;

import lionpostproject.hjs.user.repostiory.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignUpSecurityService {


    private final JpaUserRepository jpaUserRepository;

    private static final Pattern idPattern = Pattern.compile("\\w+@\\w+\\.\\w+?");

    // 아이디의 길이가 5에서 20 사이인지 확인
    @Transactional(readOnly = true)
    public void checkForDuplicateUserId(final String email) {

        Matcher matcher = idPattern.matcher(email);

        if (email.length() >= 5 || email.length() <= 20) {
            if (!matcher.matches()){
                throw new RuntimeException("아이디: 5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다");
            }
        }

        boolean account= jpaUserRepository.findByEmail(email)
                .stream()
                .anyMatch(duplicateUserId ->
                        duplicateUserId.getEmail().equals(email));

        if (account) {
            throw new RuntimeException("아이디가 중복 상태 입니다.");
        }
    }


}





