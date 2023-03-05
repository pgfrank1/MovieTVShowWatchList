package pgfrank.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

@WebServlet(
        name = "applicationStartup",
        urlPatterns = { "/application-startup" },
        loadOnStartup = 1
)
public class StartupServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    public void init() {

        ObjectMapper objectMapper = new ObjectMapper();

        getServletContext().setAttribute("apiKey", "18ea9d78ec747b84f4c00083c25afb23");

        String movieAPIUrl = "https://api.themoviedb.org/3/movie/popular?api_key="
                + getServletContext().getAttribute("apiKey") + "&language=en-US&page=1";
        String tvShowAPIUrl = "https://api.themoviedb.org/3/tv/popular?api_key="
                + getServletContext().getAttribute("apiKey") + "&language=en-US&page=1";

        try {
            URL urlMovie = new URL(movieAPIUrl);
            URL urlTVShow = new URL(tvShowAPIUrl);
            Map<String, Object> movieMap = objectMapper.readValue(urlMovie, new TypeReference<>() {});
            Map<String, Object> tvShowMap = objectMapper.readValue(urlTVShow, new TypeReference<>() {});
            //TODO: .get("results) is unnecessary EX: can use movieMap.results[i.index].overview to contain all JSON data received
            getServletContext().setAttribute("movieMap", movieMap.get("results"));
            getServletContext().setAttribute("tvShowMap", tvShowMap.get("results"));
            logger.debug("Successfully retried Movie and TV show data for the index page:\n" + movieMap + "\n" + tvShowMap);
        } catch (MalformedURLException e) {
            logger.error("There was an error with forming the url.\n" + e);
        } catch (IOException e) {
            logger.error("An IO error has occurred when attempting to read data from the API URL.\n" + e);
        }
    }
}