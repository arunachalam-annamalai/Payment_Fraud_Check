package com.payment.pps;

import com.payment.model.PaymentResponse;
import com.payment.util.JsonUtil;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PaymentProcessor implements Processor {

    private static final Logger logger = LoggerFactory.getLogger(PaymentProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        final String jsonResponse = exchange.getIn().getBody(String.class);
        PaymentResponse response = JsonUtil.fromJson(jsonResponse, PaymentResponse.class);

        if ("REJECTED".equalsIgnoreCase(response.getStatus())) {
            logger.info("Payment rejected for TransactionId: {}, message:{}", response.getTransactionId(), response.getMessage());
        } else {
            logger.info("Payment approved for TransactionId: {}, message:{}", response.getTransactionId(), response.getMessage());
        }
    }
}
