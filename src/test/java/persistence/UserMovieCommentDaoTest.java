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

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UserMovieCommentDaoTest {
    User user;
    UserMovie userMovie;
    UserMovieId userMovieId;
    UserMovieComment userMovieComment;
    UserMovieCommentId userMovieCommentId;
    GenericDao<User> daoUser;
    GenericDao<UserMovie> daoUserMovie;
    GenericDao<UserMovieComment> daoUserMovieComment;

    @BeforeEach
    void init() {
        Database database = Database.getInstance();
        database.runSQL("SetupDatabaseTest.sql");

    }
/*    @Test
    void getUserComment() {

    }*/
}
