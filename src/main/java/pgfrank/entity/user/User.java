package pgfrank.entity.user;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Users")
public class User {

    public User() { }

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

    @Column(name = "profilePhotoLocation", length = 50)
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

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<UserTVShow> userTVShows = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<UserMovie> userMovies = new LinkedHashSet<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", profilePhotoLocation='" + profilePhotoLocation + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}