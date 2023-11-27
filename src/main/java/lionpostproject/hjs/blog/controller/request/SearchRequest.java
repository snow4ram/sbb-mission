package lionpostproject.hjs.blog.controller.request;


import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class SearchRequest {


    @NotEmpty
    private String title;


    public SearchRequest(String title) {
        this.title = title;
    }
}
