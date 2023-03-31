package pgfrank.entity.user;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class UserMovieRating {
    @EmbeddedId
    private UserMovieRatingId id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "movieId", referencedColumnName = "movieId", nullable = false),
            @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    })
    private UserMovie userMovie;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Override
    public String toString() {
        return "UserMovieRating{" +
                "id=" + id +
                ", userMovie=" + userMovie +
                ", rating=" + rating +
                '}';
    }
}