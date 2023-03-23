package pgfrank.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pgfrank.entity.movie.MovieIndividualInfo;
import pgfrank.entity.tvShow.TVShowIndividualInfo;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Properties;

public class RetrieveContentData<T> implements PropertiesLoader {
    private Class<T> type;
    private Properties properties;
    private String infoUrl;
    private final Logger logger = LogManager.getLogger(this.getClass());

    public RetrieveContentData(Class<T> type) {
        this.type = type;
    }

    public <T> T getContentInfo(int id) throws JsonProcessingException {
        try {
            properties = loadProperties("/theMovieDB.properties");
        } catch (IOException e) {
            logger.error("There was an error attempting to open the movieDB properties file.\n" + e);
        } catch (Exception e) {
            logger.error("There was some kind of error while attempting to open the properties file.\n" + e);
        }

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
