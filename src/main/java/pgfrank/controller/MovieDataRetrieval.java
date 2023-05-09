package pgfrank.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pgfrank.entity.movie.MovieIndividualInfo;
import pgfrank.entity.user.User;
import pgfrank.entity.user.UserMovie;
import pgfrank.entity.user.UserMovieId;
import pgfrank.persistence.GenericDao;
import pgfrank.persistence.GenericDaoEmbeddedId;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "MovieDataRetrieval",
        value = "/MovieInfo"
)
public class MovieDataRetrieval extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Client client = ClientBuilder.newClient();

        int movieId = Integer.parseInt(request.getParameter("movie_id"));
        String tvShowInfoUrl = (String) getServletContext().getAttribute("individualMovieInfoUrl")
                + movieId
                + getServletContext().getAttribute("apiKey")
                + getServletContext().getAttribute("individualInfo");

        WebTarget target = client.target(tvShowInfoUrl);
        String dbResponse = target.request(MediaType.APPLICATION_JSON).get(String.class);


        ObjectMapper mapper = new ObjectMapper();
        MovieIndividualInfo showResponse = mapper.readValue(dbResponse, MovieIndividualInfo.class);
        request.setAttribute("movieInfo", showResponse);

        if (request.getSession().getAttribute("userName") != null)
        {
            GenericDao<User> daoUser = new GenericDao<>(User.class);
            GenericDaoEmbeddedId<UserMovie, UserMovieId> daoUserMovie = new GenericDaoEmbeddedId<>(UserMovie.class, UserMovieId.class);

            List<User> user = daoUser.getByPropertyValue("username", request.getSession().getAttribute("userName"));
            UserMovieId userMovieId = new UserMovieId(showResponse.getId(), user.get(0).getId());
            UserMovie userMovie = daoUserMovie.getTypeByEmbeddedId(userMovieId);
            if (userMovie == null)
            {
                request.setAttribute("userMovie", "THERE's nothing here");

            }
            else {
                request.setAttribute("userMovie", userMovie);
            }
        }

        String urlForward = "/individualMovieInfo.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(urlForward);
        dispatcher.forward(request, response);
    }
}
