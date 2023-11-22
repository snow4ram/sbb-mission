package lionpostproject.hjs.blog.entity;

import jakarta.persistence.*;
import lionpostproject.hjs.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    private String writing;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    @OneToMany(mappedBy = "post")
    private List<Comment> comment;

    @Builder
    public Post(String title, String author, LocalDate dateCreate, String writing) {
        this.title = title;
        this.author = author;
        this.dateCreate = dateCreate;
        this.writing = writing;
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
