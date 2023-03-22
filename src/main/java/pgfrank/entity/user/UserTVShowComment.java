package pgfrank.entity.user;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "UserTVShowComments")
public class UserTVShowComment {
    @EmbeddedId
    private UserTVShowCommentId id;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "showId", referencedColumnName = "showId", nullable = false),
            @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    })
    private UserTVShow userTVShow;

    @Column(name = "comment", nullable = false)
    private String comment;

}