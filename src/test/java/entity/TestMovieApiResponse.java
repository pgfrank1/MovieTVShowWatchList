package entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import pgfrank.entity.MoviePopularResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static org.junit.jupiter.api.Assertions.*;
public class TestMovieApiResponse {
    @Test
    public void testJSONResponse() throws Exception {
        Client client = ClientBuilder.newClient();
        String movieAPIUrl = "https://api.themoviedb.org/3/movie/popular?api_key=18ea9d78ec747b84f4c00083c25afb23&language=en-US&page=1";
        WebTarget target =
                client.target(movieAPIUrl);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        MoviePopularResponse moviePopularResponse = mapper.readValue(response, MoviePopularResponse.class);
        int resultsLength = 20;
        assertEquals(resultsLength, moviePopularResponse.getResults().size());
    }
}
