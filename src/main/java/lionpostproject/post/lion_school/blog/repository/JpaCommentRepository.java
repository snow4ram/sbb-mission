package lionpostproject.post.lion_school.blog.repository;

import lionpostproject.post.lion_school.blog.entity.Comment;
import lionpostproject.post.lion_school.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCommentRepository extends JpaRepository<Comment, Long> {
}
