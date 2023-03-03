package controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

@WebServlet(
        name = "MovieDataRetrieval",
        value = "/MovieInfo"
)
public class MovieDataRetrieval extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String urlForward = "/individualMovieInfo.jsp";
        HttpSession session = req.getSession();
        ObjectMapper objectMapper = new ObjectMapper();

        int movieId = Integer.parseInt(req.getParameter("movie_id"));
        String movieInfoUrl =  "https://api.themoviedb.org/3/movie/" + movieId + "?api_key="
                + getServletContext().getAttribute("apiKey") + "&language=en-US";

        try {
            URL urlMovieInfo = new URL(movieInfoUrl);
            Map<String, Object> movieInfo = objectMapper.readValue(urlMovieInfo, new TypeReference<>() {});
            session.setAttribute("movieInfo", movieInfo);
        } catch (MalformedURLException e) {
            logger.error("There was an error with forming the url for an individual movie.\n" + e);
        } catch (IOException e) {
            logger.error("An IO error has occurred when attempting to read data from the individual movie"
                    + " API URL.\n" + e);
        }


        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(urlForward);
        dispatcher.forward(req, resp);
    }
}
