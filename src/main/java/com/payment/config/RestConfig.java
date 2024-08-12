package com.payment.config;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RestConfig extends RouteBuilder {

    @Override
    public void configure() {
//        restConfiguration().component("servlet");

        restConfiguration()
                .component("servlet").host("localhost")
//                .contextPath("api")
                .bindingMode(RestBindingMode.auto)
                .port(8080);

//        rest("/payments/process").post()
////                .consumes("application/json")
////                .type(PaymentRequest.class)
//                .to("direct:processPayment");

        rest("/payments")
                .post("/process")
                .consumes("application/json")
                .to("direct:processPayment");
    }
}
