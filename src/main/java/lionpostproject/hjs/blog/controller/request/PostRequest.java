package lionpostproject.hjs.blog.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class PostRequest {
    @NotBlank(message = "제목을 입력해주세요")
    private String title; //제목

    @NotBlank(message = "작성자를 입력해주세요")
    private String author; //작성자

    @JsonFormat(shape = JsonFormat.Shape.STRING  , pattern = "yyyy-MM-dd" , timezone = "Asia/Seoul")
    private LocalDate dateCreate;//작성 날짜

    @NotBlank
    @Size(max = 500, message = "0이상 , 500자 미만으로 입력해주세요")
    private String writing;//글쓰기


    public PostRequest(String title, String author, LocalDate dateCreate, String writing) {
        this.title = title;
        this.author = author;
        this.dateCreate = dateCreate;
        this.writing = writing;
    }
}
