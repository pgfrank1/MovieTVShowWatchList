package pgfrank.entity.user;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
@Getter
@Setter
@Entity
@Table(name = "UserMovieComments")
public class UserMovieComment {
    @EmbeddedId
    private UserMovieCommentId id;

    @ManyToOne(fetch = FetchType.EAGER) // use eager fetching for userMovie association
    @JoinColumns({
            @JoinColumn(name = "movieId", referencedColumnName = "movieId", insertable = false, updatable = false),
            @JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false)
    })
    private UserMovie userMovie;

    @Column(name = "comment", nullable = false)
    private String comment;

    @Override
    public String toString() {
        return "UserMovieComment{" +
                "id=" + id +
                ", userMovie=" + userMovie +
                ", comment='" + comment + '\'' +
                '}';
    }
}