package com.pgfrank.waww.entity.user;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class UserTVShowRating {
    @EmbeddedId
    private UserTVShowRatingId id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "showId", referencedColumnName = "showId", nullable = false),
            @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    })
    private UserTVShow userTVShow;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Override
    public String toString() {
        return "UserTVShowRating{" +
                "id=" + id +
                ", userTVShow=" + userTVShow +
                ", rating=" + rating +
                '}';
    }
}