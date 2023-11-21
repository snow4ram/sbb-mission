package lionpostproject.hjs.blog.repository;

import lionpostproject.hjs.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCommentRepository extends JpaRepository<Comment, Long> {
}
