package lionpostproject.hjs.blog.controller.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class PostRequest {


    @NotEmpty
    private String title; //제목

    @NotEmpty
    private String author; //작성자


    @NotEmpty
    private String writing;//글쓰기


    public PostRequest(String title, String author,  String writing) {
        this.title = title;
        this.author = author;
        this.writing = writing;
    }
}
