package lionpostproject.hjs.blog.controller;


import jakarta.servlet.http.HttpSession;
import lionpostproject.hjs.blog.controller.request.CommentRequest;
import lionpostproject.hjs.blog.controller.request.PostRequest;
import lionpostproject.hjs.blog.controller.request.SearchRequest;
import lionpostproject.hjs.blog.entity.Post;
import lionpostproject.hjs.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
        //change
        List<Post> postAll = posts.findAll();

        model.addAttribute("postAll", postAll);

        return "/board/list";
    }


    @GetMapping("/write")
    public String created() {
        return "/board/write";

    }

    @PostMapping("/write")
    public ResponseEntity<Void> write(@RequestBody final PostRequest postRequest , HttpSession session) {

        posts.write(postRequest , session);

        return ResponseEntity.ok().build();

    }

    @GetMapping("/view/{postId}")
    public String viewPost(@PathVariable(name = "postId")final Long postId, Model model) {

        Post post = posts.findPosts(postId);

        model.addAttribute("post", post);

        return "/board/view";
    }

    @GetMapping("/search")
    public String searchForm(@RequestParam(name = "title")final String searchId , Model model) {

        log.info("search = {}" , searchId);

        if (searchId == null || searchId.isEmpty() || searchId.isBlank()){
            return "redirect:/api/user/list";
        }

        //change
        List<Post> search = posts.search(searchId);

        model.addAttribute("searchAll", search);

        return "/board/search";
    }


    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(name = "postId") Long id) {

        log.info("id = {}" , id);

        posts.deletePost(id);

        return ResponseEntity.noContent().build();
    }


}
