package com.pgfrank.waww.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.pgfrank.waww.entity.tvShow.TVShowIndividualInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@WebServlet(
        name = "tvShowInfo",
        value = "/TVShowInfo"
)
public class TVShowDataRetrieval extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Client client = ClientBuilder.newClient();

        int tvId = Integer.parseInt(request.getParameter("tv_id"));
        String tvShowInfoUrl = (String) getServletContext().getAttribute("individualShowInfoUrl")
                + tvId
                + getServletContext().getAttribute("apiKey")
                + getServletContext().getAttribute("individualInfo");

        WebTarget target = client.target(tvShowInfoUrl);
        String dbResponse = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        TVShowIndividualInfo showResponse = mapper.readValue(dbResponse, TVShowIndividualInfo.class);
        request.setAttribute("showInfo", showResponse);

        String urlForward = "/individualTVShowInfo.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(urlForward);
        dispatcher.forward(request, response);
    }
}
