package lionpostproject.hjs.user.repostiory;

import lionpostproject.hjs.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<User, Long>{

    Optional<User> findByEmailAndPassword(String userEmail, String userPassword);


    @Query("select u.email from User u where u.email = :userId")
    Optional<User> findByEmail(@Param("userId") String userId);


}
