package lionpostproject.hjs.blog.entity;

import jakarta.persistence.*;
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
    private String writer;

    @Column(nullable = false)
    private String comments;

    @Column(nullable = false)
    private LocalDateTime createTime;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment(String writer, String comments, LocalDateTime createTime) {
        this.writer = writer;
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
