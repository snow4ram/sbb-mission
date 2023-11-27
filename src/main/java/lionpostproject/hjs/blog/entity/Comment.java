package lionpostproject.hjs.blog.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String replyUser; //댓글 작성자.

    @Column(nullable = false)
    private String comments; // 댓글

    @Column(nullable = false)
    private LocalDateTime createTime; //댓글 작성일.

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;


    @Builder
    public Comment(String replyUser, String comments, LocalDateTime createTime) {
        this.replyUser = replyUser;
        this.comments = comments;
        this.createTime = createTime;
    }

    public void addUser(Post post) {

        if (this.post == null || this.post.equals(post)){
            if (this.post != null) {
                this.post.getComment().remove(this);
            }

            //snow4ram/sbb-mission
        }
        this.post = post;

        if (post != null) {
            if (!post.getComment().contains(this)) {
                post.getComment().add(this);
            }
        }
    }

}
