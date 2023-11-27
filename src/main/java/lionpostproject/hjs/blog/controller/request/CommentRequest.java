package lionpostproject.hjs.blog.controller.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentRequest {

    @NotEmpty
    private String replyUser; //댓글 작성자.

    @NotEmpty
    private String replyComments; // 댓글


    @NotEmpty
    private LocalDateTime replyCreateTime; //댓글 작성일.

    public CommentRequest(String replyUser, String replyComments, LocalDateTime replyCreateTime) {
        this.replyUser = replyUser;
        this.replyComments = replyComments;
        this.replyCreateTime = replyCreateTime;
    }
}
