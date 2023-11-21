package lionpostproject.post.lion_school.user.repostiory;

import lionpostproject.post.lion_school.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<User , Long> {

    Optional<User> findByEmailAndPassword(String userEmail, String userPassword);
    Optional<User> findByEmail(String userId);
}
