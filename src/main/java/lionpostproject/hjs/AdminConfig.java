package lionpostproject.hjs;

import jakarta.annotation.PostConstruct;
import lionpostproject.hjs.user.entity.User;
import lionpostproject.hjs.user.repostiory.JpaUserRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
@RequiredArgsConstructor
public class AdminConfig {


    private final JpaUserRepository jpaUserRepository;


    @PostConstruct
    public void init() {

        jpaUserRepository.save(new User(
                0L,
                "ad",
                "ad",
                "ad",
                LocalDate.now()
        ));

    }
}
