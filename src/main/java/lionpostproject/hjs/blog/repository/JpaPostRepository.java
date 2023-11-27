package lionpostproject.hjs.blog.repository;

import lionpostproject.hjs.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface JpaPostRepository extends JpaRepository<Post, Long> {


    @Query("select p from Post p where p.title like concat('%', :title ,'%')")
    List<Post> searchTitle(@Param("title") String title);


    @Modifying
    @Query("delete from Post p where p.id in :postId")
    void deleteByIdInQuery(@Param("postId") Long postId);

}
