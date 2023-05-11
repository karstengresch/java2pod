package org.opensourcerers;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/java2pod")
public class Java2PodResource {

    @ConfigProperty(name = "environment.id", defaultValue="local")
    String environmentId;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getEnvironmentId() {
        return "Your environment ID is: " + environmentId;
    }
}
