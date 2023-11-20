package lionpostproject.post.lion_school.blog.entity;

import jakarta.persistence.*;
import lionpostproject.post.lion_school.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;


    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private LocalDate dateCreate;

    @Column(nullable = false)
    private String posts;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @OneToMany
    private List<Comment> comment;

    public Post(String title, String author, LocalDate dateCreate, String posts) {
        this.title = title;
        this.author = author;
        this.dateCreate = dateCreate;
        this.posts = posts;
    }

    public void addUser(User user) {

        if (this.user == null || this.user.equals(user)){
            if (this.user != null) {
                this.user.getPosts().remove(this);
            }

            //snow4ram/sbb-mission
        }
        this.user = user;

        if (user != null) {
            if (!user.getPosts().contains(this)) {
                user.getPosts().add(this);
            }
        }
    }

}
