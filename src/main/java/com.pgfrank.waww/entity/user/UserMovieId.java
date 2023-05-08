package com.pgfrank.waww.entity.user;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class UserMovieId implements Serializable {
    private static final long serialVersionUID = 2868219758389208067L;

    public UserMovieId() {
    }

    public UserMovieId(Integer movieId, Integer userId) {
        this.movieId = movieId;
        this.userId = userId;
    }

    @Column(name = "movieId", nullable = false)
    private Integer movieId;

    @Column(name = "userId", nullable = false)
    private Integer userId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserMovieId entity = (UserMovieId) o;
        return Objects.equals(this.movieId, entity.movieId) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, userId);
    }

    @Override
    public String toString() {
        return "UserMovieId{" +
                "movieId=" + movieId +
                ", userId=" + userId +
                '}';
    }
}