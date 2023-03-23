package entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pgfrank.entity.movie.MoviePopularResponse;
import pgfrank.util.PropertiesLoader;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;
public class TestMovieApiResponse implements PropertiesLoader {
    Properties properties;
    @BeforeEach
    public void init() throws Exception {
        properties = loadProperties("/theMovieDB.properties");
    }
    @Test
    public void testJSONResponse() throws Exception {
        Client client = ClientBuilder.newClient();
        String movieAPIUrl = properties.getProperty("popular.movie.url")
                + properties.getProperty("apiKey")
                + properties.getProperty("popular.first.page");

        WebTarget target =
                client.target(movieAPIUrl);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        MoviePopularResponse moviePopularResponse = mapper.readValue(response, MoviePopularResponse.class);
        int resultsLength = 20;
        assertEquals(resultsLength, moviePopularResponse.getResults().size());
    }
}