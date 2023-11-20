package lionpostproject.post.lion_school.blog.entity;

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
}
