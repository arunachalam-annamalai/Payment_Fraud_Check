import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaymentProcessingTest {

    @Autowired
    private CamelContext camelContext;

    @Test
    public void testPaymentProcessingRoute() throws Exception {
        ProducerTemplate template = camelContext.createProducerTemplate();
        String paymentRequestJson = "{\n" +
                "      \"transactionId\": \"123e4567-e89b-12d3-a456-426614174000\",\n" +
                "      \"payerName\": \"John Doe\",\n" +
                "      \"payerBank\": \"Bank of America\",\n" +
                "      \"payerCountryCode\": \"USA\",\n" +
                "      \"payeeName\": \"Jane Doe\",\n" +
                "      \"payeeBank\": \"BNP Paribas\",\n" +
                "      \"payeeCountryCode\": \"FRA\",\n" +
                "      \"paymentInstruction\": \"Loan Repayment\",\n" +
                "      \"executionDate\": \"2024-08-11\",\n" +
                "      \"amount\": 100.50,\n" +
                "      \"currency\": \"USD\",\n" +
                "      \"creationTimestamp\": \"2024-08-11T12:00:00Z\"\n" +
                "    }"; // Your test JSON
        String response = template.requestBody("direct:processPayment", paymentRequestJson, String.class);
        Assertions.assertNotNull(response);
        // Additional assertions based on your expected response
    }
}
