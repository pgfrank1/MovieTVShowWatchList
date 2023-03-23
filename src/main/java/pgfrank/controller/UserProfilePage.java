package pgfrank.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pgfrank.entity.user.User;
import pgfrank.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "userProfilePage",
        urlPatterns = {"/UserProfilePage"}
)
public class UserProfilePage extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<User> daoUsers = new GenericDao<>(User.class);
        String urlForward = "/profilePage.jsp";

        List<User> users = daoUsers.getAll();
        logger.debug("Attempting to retrieve all users from the database");

        req.setAttribute("users", users);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(urlForward);
        dispatcher.forward(req, resp);
    }
}
