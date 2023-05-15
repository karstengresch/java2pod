package org.opensourcerers;

import jakarta.ws.rs.GET;

import jakarta.ws.rs.core.MediaType;

@Path("/api/java2pod")
public class Java2PodResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Your environment ID is: local";
    }
}
