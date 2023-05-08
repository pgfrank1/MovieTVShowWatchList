package com.pgfrank.waww.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.pgfrank.waww.entity.movie.MovieIndividualInfo;
import com.pgfrank.waww.entity.tvShow.TVShowIndividualInfo;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class RetrieveContentData<T> extends HttpServlet implements PropertiesLoader {
    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());

    public RetrieveContentData(Class<T> type) {
        this.type = type;
    }

    public <T> T getContentInfo(int id) throws JsonProcessingException {
        Client client = ClientBuilder.newClient();
        String infoUrl = null;

        if (type == TVShowIndividualInfo.class) {
            infoUrl = (String) getServletContext().getAttribute("individualShowInfoUrl");
        } else if (type == MovieIndividualInfo.class) {
            infoUrl = (String) getServletContext().getAttribute("individualMovieInfoUrl");
        }
        infoUrl += id
                + (String) getServletContext().getAttribute("apiKey")
                + getServletContext().getAttribute("individualInfo");
        logger.debug(infoUrl);
        WebTarget target = client.target(infoUrl);
        String dbResponse = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        T response = (T) mapper.readValue(dbResponse, type);

        return response;
    }
}
