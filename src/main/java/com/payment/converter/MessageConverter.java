package com.payment.converter;

import com.payment.model.FraudCheckRequest;
import com.payment.model.FraudCheckResponse;
import com.payment.util.JsonUtil;
import com.payment.util.XmlUtil;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class MessageConverter {

    public static class JsonToXmlProcessor implements Processor {
        @Override
        public void process(Exchange exchange) throws Exception {
            String jsonRequest = exchange.getIn().getBody(String.class);
            FraudCheckRequest request = JsonUtil.fromJson(jsonRequest, FraudCheckRequest.class);
            String xmlRequest = XmlUtil.toXml(request);
            exchange.getIn().setBody(xmlRequest);
        }
    }

    public static class XmlToJsonProcessor implements Processor {
        @Override
        public void process(Exchange exchange) throws Exception {
            String xmlResponse = exchange.getIn().getBody(String.class);
            FraudCheckResponse response = XmlUtil.fromXml(xmlResponse, FraudCheckResponse.class);
            String jsonResponse = JsonUtil.toJson(response);
            exchange.getIn().setBody(jsonResponse);
        }
    }
}
