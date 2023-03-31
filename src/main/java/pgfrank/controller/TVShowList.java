package pgfrank.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import pgfrank.entity.tvShow.TVShowPopularResponse;

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
        name = "TVShowList",
        urlPatterns = { "/TVShowList" }
)
public class TVShowList extends HttpServlet {
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String urlForward = "/tvShowInfo.jsp";

        Client client = ClientBuilder.newClient();
        String showAPIUrl = (String) getServletContext().getAttribute("popularShowUrl")
                + getServletContext().getAttribute("apiKey") + getServletContext().getAttribute("popularFirstPage");
        WebTarget targetShow = client.target(showAPIUrl);
        String dbResponseShow = targetShow.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        TVShowPopularResponse showPopularResponse = mapper.readValue(dbResponseShow, TVShowPopularResponse.class);
        request.setAttribute("tvShowMap", showPopularResponse);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(urlForward);
        dispatcher.forward(request, response);
    }
}
