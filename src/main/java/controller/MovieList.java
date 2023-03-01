package controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

@WebServlet(
        name = "MovieList",
        urlPatterns = { "/MovieList" }
)
public class MovieList extends HttpServlet {
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String urlForward = "/MovieInfo.jsp";

        String movieAPIUrl = "https://api.themoviedb.org/3/movie/popular?api_key="
                + getServletContext().getAttribute("apiKey") + "&language=en-US&page=1";

        URL url = new URL(movieAPIUrl);
        Map<String, Object> map = objectMapper.readValue(url, new TypeReference<>() {
        });

        getServletContext().setAttribute("mapTest", map.get("results"));

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(urlForward);
        dispatcher.forward(req, resp);
    }
}
