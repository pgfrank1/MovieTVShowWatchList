package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(
        name = "applicationStartup",
        urlPatterns = { "/IndieProject_war" },
        loadOnStartup = 1
)
public class StartupServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {

        getServletContext().setAttribute("apiKey", "18ea9d78ec747b84f4c00083c25afb23");

    }
}
