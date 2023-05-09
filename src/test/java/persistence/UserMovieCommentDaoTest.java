package persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import pgfrank.entity.movie.MovieIndividualInfo;
import pgfrank.entity.user.*;
import pgfrank.persistence.GenericDao;
import pgfrank.persistence.GenericDaoEmbeddedId;
import pgfrank.util.RetrieveContentData;
import util.Database;
import org.junit.jupiter.api.BeforeEach;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UserMovieCommentDaoTest {

    Timestamp timestamp;
    User user;
    UserMovie userMovie;
    UserMovieId userMovieId;
    UserMovieComment userMovieComment;
    UserMovieCommentId userMovieCommentId;
    GenericDao<User> daoUser;
    GenericDao<UserMovie> daoUserMovie;
    GenericDaoEmbeddedId<UserMovieComment, UserMovieCommentId> daoUserMovieComment;
    GenericDaoEmbeddedId<UserMovie, UserMovieId> daoMovieEmbeddedId;

    @BeforeEach
    void init() {
        Database database = Database.getInstance();
        database.runSQL("SetupDatabaseTest.sql");
        daoUser = new GenericDao<>(User.class);
        daoUserMovie = new GenericDao<>(UserMovie.class);
        daoUserMovieComment = new GenericDaoEmbeddedId<>(UserMovieComment.class, UserMovieCommentId.class);
        daoMovieEmbeddedId = new GenericDaoEmbeddedId<>(UserMovie.class, UserMovieId.class);
        userMovie = new UserMovie();
    }
    @Test
    void getUserCommentById() {
        user = daoUser.getTypeById(2);
        userMovieComment = daoUserMovieComment.getTypeByEmbeddedId(userMovieCommentId);
        assertEquals("This is a comment from Jeremy Smith for a Movie", userMovieComment.getComment());
    }
    @Test
    void getUserMovieByMovieId() {
        timestamp = new Timestamp(1639585800000L);
        Instant instant = timestamp.toInstant();
//        userMovieId = new UserMovieId(1234, 2);
        userMovieCommentId = new UserMovieCommentId(1234, 2, instant);
        userMovieComment = daoUserMovieComment.getTypeByEmbeddedId(userMovieCommentId);
        userMovieId = userMovieComment.getUserMovie().getId();
        userMovie = daoMovieEmbeddedId.getTypeByEmbeddedId(userMovieId);
        assertEquals(userMovie.getId().getMovieId(), userMovieComment.getUserMovie().getId().getMovieId());
    }
}
