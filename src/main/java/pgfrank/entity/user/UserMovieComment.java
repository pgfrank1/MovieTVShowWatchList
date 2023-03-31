package pgfrank.entity.user;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "UserMovieComments")
public class UserMovieComment {
    @EmbeddedId
    private UserMovieCommentId id;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "movieId", referencedColumnName = "movieId", nullable = false),
            @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
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