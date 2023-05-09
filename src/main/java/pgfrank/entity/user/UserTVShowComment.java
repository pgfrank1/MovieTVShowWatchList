package pgfrank.entity.user;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "UserTVShowComments")
public class UserTVShowComment {
    @EmbeddedId
    private UserTVShowCommentId id;

    @MapsId
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumns({
            @JoinColumn(name = "showId", referencedColumnName = "showId", nullable = false),
            @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    })
    private UserTVShow userTVShow;

    @Column(name = "comment", nullable = false)
    private String comment;

    @Override
    public String toString() {
        return "UserTVShowComment{" +
                "id=" + id +
                ", userTVShow=" + userTVShow +
                ", comment='" + comment + '\'' +
                '}';
    }
}