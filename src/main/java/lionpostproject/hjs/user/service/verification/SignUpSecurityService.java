package lionpostproject.hjs.user.service.verification;

import lionpostproject.hjs.user.controller.reqeust.JoinRequest;
import lionpostproject.hjs.user.entity.User;
import lionpostproject.hjs.user.repostiory.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignUpSecurityService {


    private final JpaUserRepository jpaUserRepository;

    Pattern pattern = Pattern.compile("^[a-z0-9.@_-]+$");

    // 아이디의 길이가 5에서 20 사이인지 확인
    @Transactional(readOnly = true)
    public void checkForDuplicateUserId(final JoinRequest joinRequest) {

        Matcher matcher = pattern.matcher(joinRequest.getEmail());

        if (joinRequest.getEmail().length() >= 5 && joinRequest.getEmail().length() <= 20) {
            if (!matcher.matches()){
                throw new RuntimeException("아이디: 5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다");
            }
        }

        boolean account= jpaUserRepository.findByEmail(joinRequest.getEmail())
                .stream()
                .anyMatch(duplicateUserId ->
                        duplicateUserId.getEmail().equals(joinRequest.getEmail()));

        if (account) {
            throw new RuntimeException("아이디가 중복 상태 입니다.");
        }
    }


}

