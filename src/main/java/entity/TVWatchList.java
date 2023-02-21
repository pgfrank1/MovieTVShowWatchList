package entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

public class TVWatchList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private User user;
    private Boolean watching;
    private Boolean planned;
    private Boolean dropped;
    private Boolean onHold;

    public TVWatchList() {
    }

    public TVWatchList(int id, User user, Boolean watching, Boolean planned, Boolean dropped, Boolean onHold) {
        this.id = id;
        this.user = user;
        this.watching = watching;
        this.planned = planned;
        this.dropped = dropped;
        this.onHold = onHold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getWatching() {
        return watching;
    }

    public void setWatching(Boolean watching) {
        this.watching = watching;
    }

    public Boolean getPlanned() {
        return planned;
    }

    public void setPlanned(Boolean planned) {
        this.planned = planned;
    }

    public Boolean getDropped() {
        return dropped;
    }

    public void setDropped(Boolean dropped) {
        this.dropped = dropped;
    }

    public Boolean getOnHold() {
        return onHold;
    }

    public void setOnHold(Boolean onHold) {
        this.onHold = onHold;
    }
}
