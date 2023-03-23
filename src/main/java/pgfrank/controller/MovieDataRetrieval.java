package pgfrank.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pgfrank.entity.tvShow.TVShowIndividualInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
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
        TVShowIndividualInfo showResponse = mapper.readValue(dbResponse, TVShowIndividualInfo.class);
        request.setAttribute("showInfo", showResponse);

        String urlForward = "/individualMovieInfo.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(urlForward);
        dispatcher.forward(request, response);
    }
}
