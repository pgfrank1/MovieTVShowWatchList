package persistence;

import pgfrank.entity.User;
import pgfrank.entity.UserMovie;
import pgfrank.persistence.UserDao;
import pgfrank.persistence.UserMovieDao;
import util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserMovieDaoTest {
    private User user;
    private UserDao userDao;
    private UserMovie userMovie;
    private UserMovieDao userMovieDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("SetupDatabaseTest.sql");
        userDao = new UserDao();
        userMovieDao = new UserMovieDao();
    }

    @Test
    void getMovieByUserId() {

        userMovie = userMovieDao.getByUserId(userDao.getById(2));
        assertEquals(1234, userMovie.getMovie_id());
    }
}
