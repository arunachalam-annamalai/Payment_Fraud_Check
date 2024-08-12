package com.payment.pps;

import com.payment.model.PaymentRequest;
import com.payment.util.JsonUtil;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class PaymentValidationProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String jsonRequest = exchange.getIn().getBody(String.class);
        PaymentRequest paymentRequest = JsonUtil.fromJson(jsonRequest, PaymentRequest.class);

        // Perform basic validation here
        if (paymentRequest.getTransactionId() == null || paymentRequest.getTransactionId().isEmpty()) {
            throw new IllegalArgumentException("Transaction ID is mandatory");
        }

        // Add more validations as needed
    }
}
