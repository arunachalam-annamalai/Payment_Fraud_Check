package com.payment.fcs;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FraudCheckRoute extends RouteBuilder {

    @Override
    public void configure() {
//        from("jms:queue:fraudCheckQueue")
//                .process(new FraudCheckProcessor())
//                .to("jms:queue:fraudCheckResponseQueue");
    }
}
