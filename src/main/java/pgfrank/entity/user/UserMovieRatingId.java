package pgfrank.entity.user;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class UserMovieRatingId implements Serializable {
    private static final long serialVersionUID = 3813302446180046370L;
    @Column(name = "movieId", nullable = false)
    private Integer movieId;

    @Column(name = "userId", nullable = false)
    private Integer userId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserMovieRatingId entity = (UserMovieRatingId) o;
        return Objects.equals(this.movieId, entity.movieId) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, userId);
    }

}