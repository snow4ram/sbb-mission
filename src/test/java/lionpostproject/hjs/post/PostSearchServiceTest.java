package lionpostproject.hjs.post;


import lionpostproject.hjs.blog.entity.Post;
import lionpostproject.hjs.blog.repository.JpaPostRepository;
import lionpostproject.hjs.blog.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostSearchServiceTest {


    @Autowired
    JpaPostRepository jpaPostRepository;

    @Autowired
    PostService postService;


    @BeforeEach
    public void write() {

        jpaPostRepository.save(new Post("title 1", "author 1", LocalDate.now(), "test 1"));
        jpaPostRepository.save(new Post("ate 2", "author 2", LocalDate.now(), "test 2"));
        jpaPostRepository.save(new Post("title 3", "author 3", LocalDate.now(), "test 3"));
        jpaPostRepository.save(new Post("title 3", "author 3", LocalDate.now(), "test 3"));
        jpaPostRepository.save(new Post("baqa 3", "author 3", LocalDate.now(), "test 3"));
        jpaPostRepository.save(new Post("title 4", "author 4", LocalDate.now(), "test 4"));
        jpaPostRepository.save(new Post("title 5", "author 5", LocalDate.now(), "test 5"));
    }


    @Test
    @DisplayName("사용자 정보 찾기")
    public void search() {

        List<Post> thor = postService.search("t");

        for (Post post : thor) {
            System.out.println(post.getTitle());
        }

    }

    @Test
    @DisplayName("사용자 정보 찾기")
    public void deleteById() {

        jpaPostRepository.deleteById(1L);


        List<Post> all = postService.findAll();

        for (Post post : all) {
            System.out.println(post.getTitle());
        }
    }
}
