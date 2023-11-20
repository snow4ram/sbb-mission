package lionpostproject.post.lion_school.user.entity;

import jakarta.persistence.*;
import lionpostproject.post.lion_school.blog.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Long authorId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private LocalDate birthday;

    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();

    public User(Long authorId, String name, String email, String password, LocalDate birthday) {
        this.authorId = authorId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
    }
}
