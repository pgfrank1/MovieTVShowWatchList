package pgfrank.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pgfrank.entity.movie.MoviePopularResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@WebServlet(
        name = "MovieList",
        urlPatterns = { "/MovieList" }
)
public class MovieList extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String urlForward = "/movieInfo.jsp";

        Client client = ClientBuilder.newClient();
        String movieAPIUrl = (String) getServletContext().getAttribute("popularMovieUrl")
                + getServletContext().getAttribute("apiKey") + getServletContext().getAttribute("popularFirstPage");
        logger.info("Attempting to retrieve Show and movie information");
        WebTarget targetMovie = client.target(movieAPIUrl);
        String dbResponseMovie = targetMovie.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        MoviePopularResponse moviePopularResponse = mapper.readValue(dbResponseMovie, MoviePopularResponse.class);
        logger.info("Mapping Show and Movie JSON responses");
        request.setAttribute("movieMap", moviePopularResponse);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(urlForward);
        dispatcher.forward(request, response);
    }
}
