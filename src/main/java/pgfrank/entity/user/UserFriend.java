package pgfrank.entity.user;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "UserFriends")
public class UserFriend {
    @EmbeddedId
    private UserFriendId id;

    @MapsId("friendId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "friendId", nullable = false)
    private User friend;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

}