package pgfrank.controller;

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
        name = "tvShowInfo",
        value = "/TVShowInfo"
)
public class TVShowDataRetrieval extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String urlForward = "/individualTVShowInfo.jsp";
        HttpSession session = req.getSession();
        ObjectMapper objectMapper = new ObjectMapper();

        int tvId = Integer.parseInt(req.getParameter("tv_id"));
        String tvShowInfoUrl =  "https://api.themoviedb.org/3/tv/" + tvId + "?api_key="
                + getServletContext().getAttribute("apiKey") + "&language=en-US";

        try {
            URL urlTvShowInfo = new URL(tvShowInfoUrl);
            Map<String, Object> tvShowInfo = objectMapper.readValue(urlTvShowInfo, new TypeReference<>() {});
            session.setAttribute("tvShowInfo", tvShowInfo);
            logger.debug("Successfully retrieved the individual TV show information: " + tvShowInfo );
        } catch (MalformedURLException e) {
            logger.error("There was an error with forming the url for an individual TV Show.\n" + e);
        } catch (IOException e) {
            logger.error("An IO error has occurred when attempting to read data from the TV Show"
                    + " API URL.\n" + e);
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(urlForward);
        dispatcher.forward(req, resp);

    }
}
