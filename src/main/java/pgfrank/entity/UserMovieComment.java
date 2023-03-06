package pgfrank.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
@Entity
@Table(name = "UserMovieComments")
public class UserMovieComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "comment")
    private String comment;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private UserMovie userMovie;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public UserMovie getUserMovie() {
        return userMovie;
    }

    public void setUserMovie(UserMovie userMovie) {
        this.userMovie = userMovie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
