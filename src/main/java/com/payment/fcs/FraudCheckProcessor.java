package com.payment.fcs;

import com.payment.model.FraudCheckRequest;
import com.payment.model.FraudCheckResponse;
import com.payment.util.ValidationUtil;
import com.payment.util.XmlUtil;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class FraudCheckProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String xmlRequest = exchange.getIn().getBody(String.class);
        FraudCheckRequest request = XmlUtil.fromXml(xmlRequest, FraudCheckRequest.class);

        FraudCheckResponse response = new FraudCheckResponse();
        response.setTransactionId(request.getTransactionId());

        if (ValidationUtil.isBlacklistedName(request.getPayerName()) ||
                ValidationUtil.isBlacklistedCountry(request.getPayerCountryCode()) ||
                ValidationUtil.isBlacklistedBank(request.getPayerBank()) ||
                ValidationUtil.isBlacklistedInstruction(request.getPaymentInstruction())) {

            response.setStatus("REJECTED");
            response.setMessage("Suspicious payment");
        } else {
            response.setStatus("APPROVED");
            response.setMessage("Nothing found, all okay");
        }

        String xmlResponse = XmlUtil.toXml(response);
        exchange.getIn().setBody(xmlResponse);
    }
}
