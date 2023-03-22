package pgfrank.entity.user;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
public class UserMovie {

    public UserMovie() {
    }

    public UserMovie(UserMovieId id, User user, Boolean watched, Boolean planned, Boolean watching, Boolean dropped) {
        this.id = id;
        this.user = user;
        this.watched = watched;
        this.planned = planned;
        this.watching = watching;
        this.dropped = dropped;
    }

    @EmbeddedId
    private UserMovieId id;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(name = "watched", nullable = false)
    private Boolean watched = false;

    @Column(name = "planned", nullable = false)
    private Boolean planned = false;

    @Column(name = "watching", nullable = false)
    private Boolean watching = false;

    @Column(name = "dropped", nullable = false)
    private Boolean dropped = false;

    @OneToOne(mappedBy = "userMovie")
    private UserMovieRating userMovieRating;

    @OneToMany(mappedBy = "userMovie")
    private Set<UserMovieComment> userMovieComments = new LinkedHashSet<>();

}