package pgfrank.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pgfrank.entity.movie.MovieIndividualInfo;
import pgfrank.entity.tvShow.TVShowIndividualInfo;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Properties;

public class RetrieveContentData<T> implements PropertiesLoader {
    private Class<T> type;
    private String infoUrl;
    private Properties properties;
    private final Logger logger = LogManager.getLogger(this.getClass());

    public RetrieveContentData(Class<T> type) throws Exception {
        this.type = type;
        properties = loadProperties("/theMovieDB.properties");
    }

    public <T> T getContentInfo(int id) throws JsonProcessingException {
        Client client = ClientBuilder.newClient();

        if (type == TVShowIndividualInfo.class) {
            infoUrl = properties.getProperty("individual.show.info.url");
        } else if (type == MovieIndividualInfo.class) {
            infoUrl = properties.getProperty("individual.movie.info.url");
        }
        infoUrl += id
                + properties.getProperty("apiKey")
                + properties.getProperty("individual.page");
        logger.debug(infoUrl);
        WebTarget target = client.target(infoUrl);
        String dbResponse = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        T response = (T) mapper.readValue(dbResponse, type);

        return response;
    }

}
