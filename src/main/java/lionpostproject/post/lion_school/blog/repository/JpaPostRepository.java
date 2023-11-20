package lionpostproject.post.lion_school.blog.repository;

import lionpostproject.post.lion_school.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPostRepository extends JpaRepository<Post , Long> {
}
