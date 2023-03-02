package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The type Movie.
 */
@Entity(name = "UserMovie")
@Table(name = "UserMovie")
public class UserMovie implements Serializable{
    @Id
    private int movie_id;
    @Column(name = "watched")
    private boolean watched;
    @Column(name = "planned")
    private boolean planned;
    @Column(name = "watching")
    private boolean watching;
    @Column(name = "dropped")
    private boolean dropped;
    @ManyToOne
    private User user;

    public UserMovie() {
    }
    public UserMovie(boolean watched, boolean planned, boolean watching, boolean dropped, User user) {
        this.watched = watched;
        this.planned = planned;
        this.watching = watching;
        this.dropped = dropped;
        this.user = user;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    public boolean isPlanned() {
        return planned;
    }

    public void setPlanned(boolean planned) {
        this.planned = planned;
    }

    public boolean isWatching() {
        return watching;
    }

    public void setWatching(boolean watching) {
        this.watching = watching;
    }

    public boolean isDropped() {
        return dropped;
    }

    public void setDropped(boolean dropped) {
        this.dropped = dropped;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

