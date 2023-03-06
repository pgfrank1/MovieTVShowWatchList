package pgfrank.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "UserFriends")
public class UserFriend implements Serializable{
    @Id
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User user;
    @Id
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User userFriend;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUserFriend() {
        return userFriend;
    }

    public void setUserFriend(User userFriend) {
        this.userFriend = userFriend;
    }
}
