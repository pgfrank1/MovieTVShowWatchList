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
import java.util.Properties;

@WebServlet(
        name = "InitialSessionServlet",
        urlPatterns = { "/index.jsp" })
public class InitialSessionServlet extends HttpServlet implements PropertiesLoader {
    private final Logger logger = LogManager.getLogger(this.getClass());
    Properties propertiesMovieDB;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            propertiesMovieDB = loadProperties("/theMovieDB.properties");
        } catch (IOException e) {
            logger.error("There was an error attempting to open the movieDB properties file.\n" + e);
        } catch (Exception e) {
            logger.error("There was some kind of error while attempting to open the properties file.\n" + e);
        }

        Client client = ClientBuilder.newClient();
        String movieAPIUrl = (String) getServletContext().getAttribute("popularMovieUrl")
                + getServletContext().getAttribute("apiKey") + getServletContext().getAttribute("popularFirstPage");
        String showAPIUrl = (String) getServletContext().getAttribute("popularShowUrl")
                + getServletContext().getAttribute("apiKey") + getServletContext().getAttribute("popularFirstPage");
        WebTarget targetMovie = client.target(movieAPIUrl);
        WebTarget targetShow = client.target(showAPIUrl);
        String dbResponseMovie = targetMovie.request(MediaType.APPLICATION_JSON).get(String.class);
        String dbResponseShow = targetShow.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        MoviePopularResponse moviePopularResponse = mapper.readValue(dbResponseMovie, MoviePopularResponse.class);
        TVShowPopularResponse showPopularResponse = mapper.readValue(dbResponseShow, TVShowPopularResponse.class);
        request.setAttribute("movieMap", moviePopularResponse);
        request.setAttribute("tvShowMap", showPopularResponse);

        String urlForward = "/WEB-INF/index.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(urlForward);
        dispatcher.forward(request, response);
    }
}
