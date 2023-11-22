package lionpostproject.hjs.blog.controller;


import jakarta.servlet.http.HttpSession;
import lionpostproject.hjs.blog.controller.request.PostRequest;
import lionpostproject.hjs.blog.entity.Post;
import lionpostproject.hjs.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lionpostproject.hjs.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class PostController {

    private final PostService posts;


    @GetMapping("/list")
    public String welcome(Model model) {
        List<Post> postAll = posts.findAll();
        model.addAttribute("postAll", postAll);
        return "/board/list";
    }


    @GetMapping("/write")
    public String created() {
        return "/board/write";

    }

    @PostMapping("/write")
    public ResponseEntity<Void> write(@RequestBody PostRequest postRequest , User user,  HttpSession session) {

        posts.write(postRequest , session);

        return ResponseEntity.ok().build();

    }


}
