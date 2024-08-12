package com.payment.bs;

import com.payment.converter.MessageConverter;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class BrokerRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("jms:queue:brokerQueue")
                .process(new MessageConverter.JsonToXmlProcessor())
                .to("jms:queue:fraudCheckQueue");

        from("jms:queue:fraudCheckResponseQueue")
                .process(new MessageConverter.XmlToJsonProcessor())
                .to("jms:queue:paymentValidationResponseQueue");
    }
}
