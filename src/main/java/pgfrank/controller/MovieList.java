package pgfrank.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "MovieList",
        urlPatterns = { "/MovieList" }
)
public class MovieList extends HttpServlet {
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String urlForward = "/MovieInfo.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(urlForward);
        dispatcher.forward(req, resp);
    }
}
