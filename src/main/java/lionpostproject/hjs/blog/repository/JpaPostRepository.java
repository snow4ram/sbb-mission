package lionpostproject.hjs.blog.repository;

import lionpostproject.hjs.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPostRepository extends JpaRepository<Post, Long> {

}
