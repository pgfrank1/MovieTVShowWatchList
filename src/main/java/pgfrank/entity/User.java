package pgfrank.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "User")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "profile_photo_location")
    private String profilePhotoLocation;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<UserMovie> userMovies = new HashSet<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<UserMovieComment> userMovieComments = new HashSet<>();
    @ManyToMany
    private Set<UserFriend> userFriends;

    public User() { }

    public User(String username, String password, String profilePhotoLocation, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.profilePhotoLocation = profilePhotoLocation;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePhotoLocation() {
        return profilePhotoLocation;
    }

    public void setProfilePhotoLocation(String profilePhotoLocation) {
        this.profilePhotoLocation = profilePhotoLocation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<UserMovie> getUserMovies() {
        return userMovies;
    }

    public void setUserMovies(Set<UserMovie> userMovies) {
        this.userMovies = userMovies;
    }

    public void addUserMovie(UserMovie userMovie) {
        userMovies.add(userMovie);
        userMovie.setUser(this);
    }

    public void removeUserMovie(UserMovie userMovie) {
        userMovies.remove(userMovie);
        userMovie.setUser(null);
    }

    public Set<UserMovieComment> getUserMovieComments() {
        return userMovieComments;
    }

    public void setUserMovieComments(Set<UserMovieComment> userMovieComments) {
        this.userMovieComments = userMovieComments;
    }

    public void addUserMovieComment(UserMovieComment userMovieComment) {
        userMovieComments.add(userMovieComment);
        userMovieComment.setUser(this);
    }

    public void removeUserMovieComment(UserMovieComment userMovieComment) {
        userMovieComments.remove(userMovieComment);
        userMovieComment.setUser(null);
    }

    public Set<UserFriend> getUsers() {
        return userFriends;
    }

    public void setUsers(Set<UserFriend> users) {
        this.userFriends = users;
    }

    public void addUserFriend(UserFriend userFriend) {
        userFriends.add(userFriend);
        userFriend.setUserFriend(this);
    }
    public void removeUserFriend(UserFriend userFriend) {
        userFriends.remove(userFriend);
        userFriend.setUserFriend(null);
    }
}
