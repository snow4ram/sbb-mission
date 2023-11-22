package lionpostproject.hjs.blog.repository;

import lionpostproject.hjs.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface JpaPostRepository extends JpaRepository<Post, Long> {


    @Query("select p from Post p where p.title like concat('%', :title ,'%')")
    List<Post> findByTitle(@Param("title") String title);







}
