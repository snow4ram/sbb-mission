package lionpostproject.post.lion_school.user.repostiory;

import lionpostproject.post.lion_school.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<User , Long> {
}
