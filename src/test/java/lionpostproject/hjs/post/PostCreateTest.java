package lionpostproject.hjs.post;


import lionpostproject.hjs.blog.entity.Post;
import lionpostproject.hjs.blog.repository.JpaPostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@Transactional
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PostCreateTest {

    @Autowired
    JpaPostRepository postRepository;


    @BeforeEach
    public void create() {
        postRepository.save(new Post("test title", "au", LocalDate.now(), "writing"));
    }


    @Test
    public void delete() {

        postRepository.deleteByIdInQuery(1L);


    }

}
