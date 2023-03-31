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
@Embeddable
public class UserFriendId implements Serializable {
    private static final long serialVersionUID = 6297047867372645194L;
    @Column(name = "friendId", nullable = false)
    private Integer friendId;

    @Column(name = "userId", nullable = false)
    private Integer userId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserFriendId entity = (UserFriendId) o;
        return Objects.equals(this.friendId, entity.friendId) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(friendId, userId);
    }

    @Override
    public String toString() {
        return "UserFriendId{" +
                "friendId=" + friendId +
                ", userId=" + userId +
                '}';
    }
}