package pgfrank.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pgfrank.entity.user.*;
import pgfrank.persistence.GenericDao;
import pgfrank.persistence.GenericDaoEmbeddedId;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "userProfilePage",
        urlPatterns = {"/UserProfilePage"}
)
public class UserProfilePage extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        GenericDaoEmbeddedId<UserMovie, UserMovieId> daoEmbeddedMovieId = new GenericDaoEmbeddedId<>(UserMovie.class, UserMovieId.class);
        GenericDaoEmbeddedId<UserTVShow, UserTVShowId> daoEmbeddedTVShowId = new GenericDaoEmbeddedId<>(UserTVShow.class, UserTVShowId.class);

        List<UserMovie> userMovies = daoEmbeddedMovieId.getAll();
        List<UserTVShow> userTVShows = daoEmbeddedTVShowId.getAll();

        req.setAttribute("userMovies", userMovies);
        req.setAttribute("userTVShows", userTVShows);

        String urlForward = "/profilePage.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(urlForward);
        dispatcher.forward(req, resp);
    }
}
