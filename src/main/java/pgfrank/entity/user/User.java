package pgfrank.entity.user;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Users")
public class User {

    public User() {}

    public User(String username, String profilePhotoLocation, String firstName, String lastName) {
        this.username = username;
        this.profilePhotoLocation = profilePhotoLocation;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "profilePhotoLocation", nullable = false, length = 50)
    private String profilePhotoLocation;

    @Column(name = "firstName", nullable = false, length = 50)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 50)
    private String lastName;

    @ManyToMany
    @JoinTable(name = "UserFriends",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "friendId"))
    private Set<User> user = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "UserFriends",
            joinColumns = @JoinColumn(name = "friendId"),
            inverseJoinColumns = @JoinColumn(name = "userId"))
    private Set<User> friend = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserTVShow> userTVShows = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserMovie> userMovies = new LinkedHashSet<>();

}