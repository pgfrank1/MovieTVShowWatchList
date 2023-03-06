package pgfrank.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * The type Movie.
 */
@Entity(name = "UserMovie")
@Table(name = "UserMovie")
public class UserMovie implements Serializable {
    @Id
    @Column(name = "movie_id")
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
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "userMovie", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<UserMovieComment> userMovieComments;

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

    public Set<UserMovieComment> getUserMovieComments() {
        return userMovieComments;
    }

    public void setUserMovieComment(Set<UserMovieComment> userMovieComment) {
        userMovieComments = userMovieComment;
    }

    public void addUserMovieComment(UserMovieComment userMovieComment) {
        userMovieComments.add(userMovieComment);
        userMovieComment.setUserMovie(this);
    }
    public void removeUserMovieComment(UserMovieComment userMovieComment) {
        userMovieComments.remove(userMovieComment);
        userMovieComment.setUserMovie(null);
    }
}

