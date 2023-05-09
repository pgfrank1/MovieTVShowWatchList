package persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pgfrank.entity.movie.MovieIndividualInfo;
import pgfrank.entity.tvShow.TVShowIndividualInfo;
import pgfrank.entity.user.*;
import pgfrank.persistence.GenericDao;
import pgfrank.persistence.GenericDaoEmbeddedId;
import pgfrank.util.RetrieveContentData;
import util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserTVShowDaoTest {

    User user;
    List<User> users;
    TVShowIndividualInfo movie;
    UserTVShow userMovie;
    UserTVShowId userMovieId;
    List<UserTVShow> userMovies;
    GenericDao<User> daoUser;
    GenericDao<UserTVShow> daoUserMovie;
    GenericDaoEmbeddedId<UserTVShow, UserTVShowId> daoMovieEmbeddedId;
    RetrieveContentData<TVShowIndividualInfo> contentData;

    @BeforeEach
    void setUp() throws Exception {
        Database database = Database.getInstance();
        database.runSQL("SetupDatabaseTest.sql");
        daoUser = new GenericDao<>(User.class);
        daoUserMovie = new GenericDao<>(UserTVShow.class);
        daoMovieEmbeddedId = new GenericDaoEmbeddedId<>(UserTVShow.class, UserTVShowId.class);
        userMovie = new UserTVShow();
        contentData = new RetrieveContentData<>(TVShowIndividualInfo.class);
        userMovieId = new UserTVShowId(123, 1);
        users = daoUser.getAll();
        userMovies = daoUserMovie.getAll();
    }
    @Test
    void getByMovieId() {
        userMovie = daoMovieEmbeddedId.getTypeByEmbeddedId(userMovieId);
        assertEquals(123, (int) userMovie.getId().getShowId());
    }
    @Test
    void getMovieTitleById() throws JsonProcessingException {
        movie =  contentData.getContentInfo(550);
        assertEquals("Till Death Us Do Part", movie.getName());
    }
    @Test
    void addMovie() {
        UserTVShowId userMovieId = new UserTVShowId(1234, 1);
        user = daoUser.getTypeById(1);
        UserTVShow movie1 = new UserTVShow(userMovieId, user, false, true, false, false);
        daoMovieEmbeddedId.addTypeByEmbeddedId(movie1);
        userMovies = daoUserMovie.getAll();
        assertEquals(userMovieId.getShowId(), userMovies.get(2).getId().getShowId());
        assertEquals(userMovieId.getUserId(), userMovies.get(2).getId().getUserId());
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
        userMovie = daoMovieEmbeddedId.getTypeByEmbeddedId(userMovieId);
        userMovie.setDropped(true);
        userMovie.setWatched(false);
        daoMovieEmbeddedId.saveOrUpdateType(userMovie);
        UserTVShow testMovie =  daoMovieEmbeddedId.getTypeByEmbeddedId(userMovieId);
        assertTrue(testMovie.getDropped());
        assertFalse(testMovie.getWatched());
    }
}