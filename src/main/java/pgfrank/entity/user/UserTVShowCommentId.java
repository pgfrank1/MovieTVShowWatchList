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
@Embeddable
public class UserTVShowCommentId implements Serializable {
    private static final long serialVersionUID = 494338642413274748L;
    @Column(name = "showId", nullable = false)
    private Integer showId;

    @Column(name = "userId", nullable = false)
    private Integer userId;

    @Column(name = "timeCreated", nullable = false)
    private Instant timeCreated;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserTVShowCommentId entity = (UserTVShowCommentId) o;
        return Objects.equals(this.showId, entity.showId) &&
                Objects.equals(this.timeCreated, entity.timeCreated) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(showId, timeCreated, userId);
    }

    @Override
    public String toString() {
        return "UserTVShowCommentId{" +
                "showId=" + showId +
                ", userId=" + userId +
                ", timeCreated=" + timeCreated +
                '}';
    }
}