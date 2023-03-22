package pgfrank.entity.user;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class UserMovieCommentId implements Serializable {
    private static final long serialVersionUID = 7050285905403223771L;
    @Column(name = "movieId", nullable = false)
    private Integer movieId;

    @Column(name = "userId", nullable = false)
    private Integer userId;

    @Column(name = "timeCreated", nullable = false)
    private Instant timeCreated;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserMovieCommentId entity = (UserMovieCommentId) o;
        return Objects.equals(this.movieId, entity.movieId) &&
                Objects.equals(this.timeCreated, entity.timeCreated) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, timeCreated, userId);
    }

}