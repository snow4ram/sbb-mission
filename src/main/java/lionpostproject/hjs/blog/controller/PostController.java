package lionpostproject.hjs.blog.controller;


import jakarta.servlet.http.HttpSession;
import lionpostproject.hjs.blog.controller.request.PostRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lionpostproject.hjs.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;


@Slf4j
@Controller
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;


    @GetMapping("/list")
    public String welcome(Model model) {

        return "/board/list";
    }


    @GetMapping("/new")
    public String created() {
        return "/board/posting";

    }

    @PostMapping("/new")
    public ResponseEntity<Void> create(@RequestBody PostRequest postRequest , HttpSession session) {

        postService.write(postRequest , session);

        return ResponseEntity.ok().build();

    }


}
