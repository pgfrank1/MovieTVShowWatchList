package com.pgfrank.waww.entity.user;

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
public class UserTVShowRatingId implements Serializable {
    private static final long serialVersionUID = 257465687234482965L;
    @Column(name = "userId", nullable = false)
    private Integer userId;

    @Column(name = "showId", nullable = false)
    private Integer showId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserTVShowRatingId entity = (UserTVShowRatingId) o;
        return Objects.equals(this.showId, entity.showId) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(showId, userId);
    }

    @Override
    public String toString() {
        return "UserTVShowRatingId{" +
                "userId=" + userId +
                ", showId=" + showId +
                '}';
    }
}