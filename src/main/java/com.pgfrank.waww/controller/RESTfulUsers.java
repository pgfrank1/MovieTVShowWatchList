package com.pgfrank.waww.controller;

import com.pgfrank.waww.persistence.GenericDao;
import com.pgfrank.waww.entity.user.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
public class RESTfulUsers {
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response getUsers() {
        GenericDao<User> user = new GenericDao<>(User.class);
        List<User> users = user.getAll();
        StringBuilder listUsers = new StringBuilder();
        for (User user1 : users) {
            listUsers.append("<li>").append(user1.getUsername()).append("</li>");
        }
        return Response.status(200).entity(listUsers.toString()).build();
    }
}
