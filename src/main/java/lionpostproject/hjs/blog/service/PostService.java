package lionpostproject.hjs.blog.service;


import jakarta.servlet.http.HttpSession;
import lionpostproject.hjs.blog.controller.request.PostRequest;
import lionpostproject.hjs.blog.entity.Post;
import lionpostproject.hjs.blog.repository.JpaPostRepository;
import lionpostproject.hjs.user.entity.User;
import lionpostproject.hjs.user.repostiory.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static lionpostproject.hjs.user.service.UserServiceIml.SESSION_KEY;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final JpaUserRepository jpaUserRepository;

    private final JpaPostRepository jpaPostRepository;

    @Transactional
    public void write(PostRequest postRequest , HttpSession session) {

        String userId = (String) session.getAttribute(SESSION_KEY);


        //change
        User user = jpaUserRepository.findByEmail(userId).orElseThrow();


        //change
        Post post = Post.builder()
                .title(postRequest.getTitle())
                .author(postRequest.getAuthor())
                .dateCreate(LocalDate.now())
                .writing(postRequest.getWriting())
                .build();

        post.addUser(user);

        jpaPostRepository.save(post);

    }

    //change
    @Transactional(readOnly = true)
    public List<Post> search(String titleName) {
        if (titleName.isBlank() || titleName.trim().length() == 0) {
            throw new RuntimeException("입력한 값이 없습니다.");
        }
        return jpaPostRepository.searchTitle(titleName);
    }

    //change
    @Transactional(readOnly = true)
    public Post findPosts(final Long id) {
        return jpaPostRepository.findById(id).orElseThrow();
    }


    //change
    @Transactional(readOnly = true)
    public List<Post> findAll() {
        return jpaPostRepository.findAll();
    }

    @Transactional
    public void deletePost(final Long id) {
        jpaPostRepository.deleteByIdInQuery(id);
    }
}
