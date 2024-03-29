package persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import pgfrank.entity.movie.MovieIndividualInfo;
import pgfrank.entity.user.User;
import pgfrank.entity.user.UserMovie;
import pgfrank.entity.user.UserMovieId;
import pgfrank.persistence.GenericDao;
import pgfrank.persistence.GenericDaoEmbeddedId;
import pgfrank.util.RetrieveContentData;
import util.Database;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UserMovieDaoTest {

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
    void setUp() throws Exception {
        Database database = Database.getInstance();
        database.runSQL("SetupDatabaseTest.sql");
        daoUser = new GenericDao<>(User.class);
        daoUserMovie = new GenericDao<>(UserMovie.class);
        daoMovieEmbeddedId = new GenericDaoEmbeddedId<>(UserMovie.class, UserMovieId.class);
        userMovie = new UserMovie();
        contentData = new RetrieveContentData<>(MovieIndividualInfo.class);
        userMovieId = new UserMovieId(1234, 2);
        users = daoUser.getAll();
        userMovies = daoUserMovie.getAll();
    }
    @Test
    void getByMovieId() {
        userMovie = (UserMovie) daoMovieEmbeddedId.getTypeByEmbeddedId(userMovieId);
        assertEquals(1234, (int) userMovie.getId().getMovieId());
    }
    @Test
    void getMovieTitleById() throws JsonProcessingException {
        movie = (MovieIndividualInfo) contentData.getContentInfo(550);
        assertEquals("Fight Club", movie.getTitle());
    }
    @Test
    void addMovie() {
        UserMovieId userMovieId = new UserMovieId(550, 1);
        user = daoUser.getTypeById(1);
        UserMovie movie1 = new UserMovie(userMovieId, user, false, true, false, false);
        daoMovieEmbeddedId.addTypeByEmbeddedId(movie1);
        userMovies = daoUserMovie.getAll();
        assertEquals(userMovieId.getMovieId(), userMovies.get(0).getId().getMovieId());
        assertEquals(userMovieId.getUserId(), userMovies.get(0).getId().getUserId());
    }
    @Test
    void deleteMovie() {
        userMovie = daoMovieEmbeddedId.getTypeByEmbeddedId(userMovieId);
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