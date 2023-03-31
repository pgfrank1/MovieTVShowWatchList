package pgfrank.entity.user;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class UserTVShow {
    @EmbeddedId
    private UserTVShowId id;

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