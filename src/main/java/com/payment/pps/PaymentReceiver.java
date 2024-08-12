package com.payment.pps;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class PaymentReceiver extends RouteBuilder {

    @Override
    public void configure() {
//        from("jms:queue:paymentQueue")
//                .process(new PaymentValidationProcessor())
//                .to("jms:queue:brokerQueue");
    }
}
