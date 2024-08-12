package com.payment.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@ConfigurationProperties
public class CamelConfig {

    @Value("${spring.activemq.broker-url}")
    private final String brokerUrl;

    @Value("${spring.activemq.user}")
    private final String user;

    @Value("${spring.activemq.password}")
    private final String password;

    public CamelConfig(String brokerUrl,  String user, String password) {
        this.brokerUrl = brokerUrl;
        this.user = user;
        this.password = password;
    }

    @Bean
    CamelContextConfiguration contextConfiguration() {
        return new CamelContextConfiguration() {
            @Override
            public void beforeApplicationStart(CamelContext camelContext) {
                ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, brokerUrl);
                camelContext.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
            }

            @Override
            public void afterApplicationStart(CamelContext camelContext) {
                // log the configs

            }
        };
    }
}
