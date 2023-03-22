package pgfrank.controller;

import pgfrank.util.PropertiesLoader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Properties;

@WebListener
public class StartupServlet extends HttpServlet implements PropertiesLoader, ServletContextListener {
    private final Logger logger = LogManager.getLogger(this.getClass());

    Properties properties;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            properties = loadProperties("/theMovieDB.properties");
            sce.getServletContext().setAttribute("apiKey", properties.getProperty("apiKey"));
            sce.getServletContext().setAttribute("popularFirstPage", properties.getProperty("popular.first.page"));
            sce.getServletContext().setAttribute("popularMovieUrl", properties.getProperty("popular.movie.url"));
            sce.getServletContext().setAttribute("popularShowUrl", properties.getProperty("popular.show.url"));
            sce.getServletContext().setAttribute("posterImageUrl", properties.getProperty("poster.image.url"));
            sce.getServletContext().setAttribute("individualMovieInfoUrl", properties.getProperty("individual.movie.info.url"));
            sce.getServletContext().setAttribute("individualShowInfoUrl", properties.getProperty("individual.show.info.url"));
            sce.getServletContext().setAttribute("individualInfo", properties.getProperty("individual.page"));
        } catch (IOException e) {
            logger.error("There was an error attempting to open the movieDB properties file.\n" + e);
        } catch (Exception e) {
            logger.error("There was some kind of error while attempting to open the properties file.\n" + e);
        }
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) { }
}
