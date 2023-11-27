package lionpostproject.hjs.blog.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class PostRequest {


    @NotEmpty
    private String title; //제목

    @NotEmpty
    private String author; //작성자

    @JsonFormat(shape = JsonFormat.Shape.STRING  , pattern = "yyyy-MM-dd" , timezone = "Asia/Seoul")
    private LocalDate dateCreate;//작성 날짜

    @NotEmpty
    private String writing;//글쓰기


    public PostRequest(String title, String author, LocalDate dateCreate, String writing) {
        this.title = title;
        this.author = author;
        this.dateCreate = dateCreate;
        this.writing = writing;
    }
}
