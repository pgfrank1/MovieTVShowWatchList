package persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pgfrank.waww.entity.tvShow.TVShowIndividualInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import com.pgfrank.waww.entity.movie.MovieIndividualInfo;
import com.pgfrank.waww.entity.user.User;
import com.pgfrank.waww.entity.user.UserMovie;
import com.pgfrank.waww.entity.user.UserMovieId;
import com.pgfrank.waww.persistence.GenericDao;
import com.pgfrank.waww.persistence.GenericDaoEmbeddedId;
import com.pgfrank.waww.util.RetrieveContentData;
import util.Database;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UserMovieDaoTest {
    private final Logger logger = LogManager.getLogger(this.getClass());
    User user;
    List<User> users;
    MovieIndividualInfo movie;
    UserMovie userMovie;
    UserMovieId userMovieId;
    List<UserMovie> userMovies;
    GenericDao<User> daoUser;
    GenericDao<UserMovie> daoUserMovie;
    GenericDaoEmbeddedId<UserMovie, UserMovieId> daoMovieEmbeddedId;
    RetrieveContentData<MovieIndividualInfo> contentData;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("SetupDatabaseTest.sql");
        daoUser = new GenericDao<>(User.class);
        daoUserMovie = new GenericDao<>(UserMovie.class);
        daoMovieEmbeddedId = new GenericDaoEmbeddedId<>(UserMovie.class, UserMovieId.class);
        userMovie = new UserMovie();
        contentData = new RetrieveContentData<>(MovieIndividualInfo.class);
        userMovieId = new UserMovieId(297761, 2);
        users = daoUser.getAll();
        userMovies = daoUserMovie.getAll();
    }
    @Test
    void getByMovieId() {
        userMovie = (UserMovie) daoMovieEmbeddedId.getTypeByEmbeddedId(userMovieId);
        assertEquals(297761, (int) userMovie.getId().getMovieId());
    }
    @Test
    void getMovieTitleById() throws JsonProcessingException {
        movie = (MovieIndividualInfo) contentData.getContentInfo(userMovies.get(0).getId().getMovieId());
        assertEquals("Suicide Squad", movie.getTitle());
    }
    @Test
    void addMovie() {
        UserMovieId userMovieId = new UserMovieId(550, 1);
        user = daoUser.getTypeById(1);
        UserMovie movie1 = new UserMovie(userMovieId, user, true, false, false, false);
        daoUserMovie.insertType(movie1);
        userMovies = daoUserMovie.getAll();
        assertEquals(userMovieId.getMovieId(), userMovies.get(0).getId().getMovieId());
        assertEquals(userMovieId.getUserId(), userMovies.get(0).getId().getUserId());
    }
    @Test
    void deleteMovie() {
        userMovie = (UserMovie) daoMovieEmbeddedId.getTypeByEmbeddedId(userMovieId);
        daoMovieEmbeddedId.deleteType(userMovie);
        daoMovieEmbeddedId.getAll();
        assertNull(daoMovieEmbeddedId.getTypeByEmbeddedId(userMovieId));
    }
    @Test
    void updateMovie() {
        userMovie = (UserMovie) daoMovieEmbeddedId.getTypeByEmbeddedId(userMovieId);
        userMovie.setDropped(true);
        userMovie.setWatched(false);
        daoMovieEmbeddedId.saveOrUpdateType(userMovie);
        UserMovie testMovie =  (UserMovie) daoMovieEmbeddedId.getTypeByEmbeddedId(userMovieId);
        assertTrue(testMovie.getDropped());
        assertFalse(testMovie.getWatched());
    }
}