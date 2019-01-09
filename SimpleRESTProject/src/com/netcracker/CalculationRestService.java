package com.netcracker;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/calc")
public class CalculationRestService {
    //Used for Browser
    @GET
    @Path("/add/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String add(@PathParam("a") int a, @PathParam("b") int b) {
        int result = a + b;
        return getHtmlString(" + ", a, b, result);
    }

    @GET
    @Path("/sub/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String sub(@PathParam("a") int a, @PathParam("b") int b) {
        int result = a - b;
        return getHtmlString(" - ", a, b, result);
    }

    @GET
    @Path("/mul/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String mul(@PathParam("a") int a, @PathParam("b") int b) {
        double result = a * b;
        return getHtmlString(" * ", a, b, result);
    }

    @GET
    @Path("/div/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String div(@PathParam("a") int a, @PathParam("b") int b) {
        double result = Double.NaN;
        if(b != 0) {
            result = (double) a / (double) b;
        }
        return getHtmlString(" / ", a, b, result);
    }


    //Used from main()

    @POST
    @Path("/add/{a}/{b}")
    @Produces(MediaType.APPLICATION_JSON)
    public Expression addPost(@PathParam("a") int a, @PathParam("b") int b) {
        int result = a + b;
        return new Expression(" + ", a, b, result);
    }

    @POST
    @Path("/sub/{a}/{b}")
    @Produces(MediaType.APPLICATION_JSON)
    public Expression subPost(@PathParam("a") int a, @PathParam("b") int b) {
        int result = a - b;
        return new Expression(" - ", a, b, result);
    }

    @POST
    @Path("/mul/{a}/{b}")
    @Produces(MediaType.APPLICATION_JSON)
    public Expression mulPost(@PathParam("a") int a, @PathParam("b") int b) {
        double result = a * b;
        return new Expression(" * ", a, b, result);
    }

    @POST
    @Path("/div/{a}/{b}")
    @Produces(MediaType.APPLICATION_JSON)
    public Expression divPost(@PathParam("a") int a, @PathParam("b") int b) {
        double result = Double.NaN;
        if(b != 0) {
            result = (double) a / (double) b;
        }
        return new Expression(" / ", a, b, result);
    }



    private String getHtmlString(String operation, int a, int b, double result) {
        String html = "<html>"+
                "<title>"+"Hello from CalculationRestService"+"</title>"+
                "<body><h1>" + a + operation + b + " = " + result +"</h1></body>"+
                "</html>";

        return html;
    }
}
