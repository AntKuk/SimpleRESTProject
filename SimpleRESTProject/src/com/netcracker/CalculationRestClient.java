package com.netcracker;

import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class CalculationRestClient {

    public static void main(String[] args) {
        int a = 0;
        int b = 1;

        Calculator add = new Calculator(a, b, "add");
        System.out.println(add.doOpeation());

        Calculator sub = new Calculator(a,b,"sub");
        System.out.println(sub.doOpeation());

        Calculator mul = new Calculator(a, b, "mul");
        System.out.println(mul.doOpeation());

        Calculator div = new Calculator(a, b, "div");
        System.out.println(div.doOpeation());

    }
}
