package controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

@WebServlet(
        name = "applicationStartup",
        urlPatterns = { "/IndieProject_war" },
        loadOnStartup = 1
)
public class StartupServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {

        ObjectMapper objectMapper = new ObjectMapper();

        getServletContext().setAttribute("apiKey", "18ea9d78ec747b84f4c00083c25afb23");

        String movieAPIUrl = "https://api.themoviedb.org/3/movie/popular?api_key="
                + getServletContext().getAttribute("apiKey") + "&language=en-US&page=1";
        String tvShowAPIUrl = "https://api.themoviedb.org/3/tv/popular?api_key="
                + getServletContext().getAttribute("apiKey") + "&language=en-US&page=1";

        URL urlMovie;
        URL urlTVShow;
        try {
            urlMovie = new URL(movieAPIUrl);
            urlTVShow = new URL(tvShowAPIUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        Map<String, Object> movieMap;
        Map<String, Object> tvShowMap;
        try {
            movieMap = objectMapper.readValue(urlMovie, new TypeReference<>() {});
            tvShowMap = objectMapper.readValue(urlTVShow, new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        getServletContext().setAttribute("movieMap", movieMap.get("results"));
        getServletContext().setAttribute("tvShowMap", tvShowMap.get("results"));

    }
}
