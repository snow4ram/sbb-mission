package lionpostproject.hjs.user.repostiory;

import lionpostproject.hjs.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailAndPassword(String userEmail, String userPassword);


    Optional<User> findByEmail(String userId);
}
