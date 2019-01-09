package com.netcracker;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Calculator {
    private static final String REST_SERVICE_URL = "http://localhost:8080/rest/calc";
    private int a;
    private int b;
    private String operation; //operation path from CalculationRestService - add, sub, mul or div


    public Calculator(int a, int b, String operation) {
        this.a = a;
        this.b = b;
        this.operation = operation;
    }

    public Expression doOpeation() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(REST_SERVICE_URL).path("/{op}/{a}/{b}")
                .resolveTemplate("op", this.operation)
                .resolveTemplate("a", this.a)
                .resolveTemplate("b", this.b);
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        Response response = builder.post(null);
        Expression expression = response.readEntity(Expression.class);
        return expression;
    }
}
