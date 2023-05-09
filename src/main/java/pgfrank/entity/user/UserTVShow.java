package pgfrank.entity.user;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "UserTVShow")
public class UserTVShow {
    @EmbeddedId
    private UserTVShowId id;

    public UserTVShow() {
    }

    public UserTVShow(UserTVShowId id, User user, Boolean watched, Boolean planned, Boolean watching, Boolean dropped) {
        this.id = id;
        this.user = user;
        this.watched = watched;
        this.planned = planned;
        this.watching = watching;
        this.dropped = dropped;
    }

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

    @OneToMany(mappedBy = "userTVShow")
    private Set<UserTVShowComment> userTVShowComments = new LinkedHashSet<>();

    @OneToOne(mappedBy = "userTVShow")
    private UserTVShowRating userTVShowRating;

    @Override
    public String toString() {
        return "UserTVShow{" +
                "id=" + id +
                ", user=" + user +
                ", watched=" + watched +
                ", planned=" + planned +
                ", watching=" + watching +
                ", dropped=" + dropped +
                '}';
    }
}