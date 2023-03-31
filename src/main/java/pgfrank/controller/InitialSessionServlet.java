package pgfrank.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pgfrank.entity.movie.MoviePopularResponse;
import pgfrank.entity.tvShow.TVShowPopularResponse;
import pgfrank.util.PropertiesLoader;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@WebServlet(
        name = "InitialSessionServlet",
        urlPatterns = { "/index.jsp" })
public class InitialSessionServlet extends HttpServlet implements PropertiesLoader {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Client client = ClientBuilder.newClient();
        String movieAPIUrl = (String) getServletContext().getAttribute("popularMovieUrl")
                + getServletContext().getAttribute("apiKey") + getServletContext().getAttribute("popularFirstPage");
        String showAPIUrl = (String) getServletContext().getAttribute("popularShowUrl")
                + getServletContext().getAttribute("apiKey") + getServletContext().getAttribute("popularFirstPage");
        logger.info("Attempting to retrieve Show and movie information");
        WebTarget targetMovie = client.target(movieAPIUrl);
        WebTarget targetShow = client.target(showAPIUrl);
        String dbResponseMovie = targetMovie.request(MediaType.APPLICATION_JSON).get(String.class);
        String dbResponseShow = targetShow.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        MoviePopularResponse moviePopularResponse = mapper.readValue(dbResponseMovie, MoviePopularResponse.class);
        TVShowPopularResponse showPopularResponse = mapper.readValue(dbResponseShow, TVShowPopularResponse.class);
        logger.info("Mapping Show and Movie JSON responses");
        request.setAttribute("movieMap", moviePopularResponse);
        request.setAttribute("tvShowMap", showPopularResponse);

        String urlForward = "/WEB-INF/index.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(urlForward);
        dispatcher.forward(request, response);
    }
}
