package com.example;

import org.graalvm.polyglot.Context;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        try (Context context = Context.create()) {
            context.eval("js", "print('Hello JavaScript!');");
        }
        return "Hello from RESTEasy Reactive";
    }
}