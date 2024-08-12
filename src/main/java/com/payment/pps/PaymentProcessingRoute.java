package com.payment.pps;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class PaymentProcessingRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("direct:processPayment")
                .process(new PaymentValidationProcessor())
                .to("jms:queue:brokerQueue");

        from("jms:queue:paymentValidationResponseQueue")
                .process(new PaymentProcessor());

    }
}
