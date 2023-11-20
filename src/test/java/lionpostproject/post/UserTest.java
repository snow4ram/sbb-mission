package lionpostproject.post;


import lionpostproject.post.lion_school.blog.entity.Comment;
import lionpostproject.post.lion_school.blog.entity.Post;
import lionpostproject.post.lion_school.blog.repository.JpaCommentRepository;
import lionpostproject.post.lion_school.blog.repository.JpaPostRepository;
import lionpostproject.post.lion_school.user.entity.User;
import lionpostproject.post.lion_school.user.repostiory.JpaUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserTest {

    @Autowired
    JpaUserRepository userRepository;

    @Autowired
    JpaPostRepository postRepository;

    @Autowired
    JpaCommentRepository commentRepository;

    @Test
    public void create() {

        AtomicLong atomicLong = new AtomicLong(1L);
        User user1 = new User(atomicLong.getAndIncrement() , "test Name", "test id", "test Password", LocalDate.now());
        User user2 = new User(atomicLong.getAndIncrement() , "test Name", "test id", "test Password", LocalDate.now());
        User user3 = new User(atomicLong.getAndIncrement() , "test Name", "test id", "test Password", LocalDate.now());

        userRepository.saveAll(List.of(user1 , user2 , user3));


        Comment comment = new Comment("test Name", "test id", LocalDateTime.now());
        commentRepository.save(comment);


        Post post1 = new Post("Title 1", user1.getName(), LocalDate.now(), "Content 1");
        Post post2 = new Post("Title 2", user1.getName(), LocalDate.now(), "Content 2");

        Post post3 = new Post("Title 3", user2.getName(), LocalDate.now(), "Content 3");
        Post post4 = new Post("Title 4", user2.getName(), LocalDate.now(), "Content 4");

        Post post5 = new Post("Title 5", user3.getName(), LocalDate.now(), "Content 5");
        Post post6 = new Post("Title 6", user3.getName(), LocalDate.now(), "Content 6");

        //user 1: 1 ~ 2
        post1.addUser(user1);
        post2.addUser(user1);

        //user 2: 3 ~ 4
        post3.addUser(user2);
        post4.addUser(user2);

        //user 3:  5 ~ 6
        post5.addUser(user3);
        post6.addUser(user3);


        postRepository.saveAll(List.of(post1, post2 , post3 , post4 , post5 ,post6));




    }


}
