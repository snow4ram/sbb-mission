package lionpostproject.hjs.blog.service;


import jakarta.servlet.http.HttpSession;
import lionpostproject.hjs.blog.entity.Post;
import lionpostproject.hjs.blog.controller.request.PostRequest;
import lionpostproject.hjs.blog.repository.JpaPostRepository;
import lionpostproject.hjs.user.entity.User;
import lionpostproject.hjs.user.repostiory.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final JpaUserRepository jpaUserRepository;

    private final JpaPostRepository jpaPostRepository;

    private static final String SESSION_KEY = "id";

    public void write(PostRequest postRequest , HttpSession session) {

        String userId = (String) session.getAttribute(SESSION_KEY);


        User user = jpaUserRepository.findByEmail(userId).orElseThrow();


        Post post = Post.builder()
                .title(postRequest.getTitle())
                .author(postRequest.getAuthor())
                .dateCreate(LocalDate.now())
                .writing(postRequest.getWriting())
                .build();

        post.addUser(user);

        jpaPostRepository.save(post);

    }
}
