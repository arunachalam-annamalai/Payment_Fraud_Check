package com.payment.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@XmlRootElement(name = "PaymentRequest")
public class PaymentRequest {
    private String transactionId;
    private String payerName;
    private String payerBank;
    private String payerCountryCode;
    private String payeeName;
    private String payeeBank;
    private String payeeCountryCode;
    private String paymentInstruction;
    private LocalDate executionDate;
    private BigDecimal amount;
    private String currency;
    private LocalDateTime creationTimestamp;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getPayerBank() {
        return payerBank;
    }

    public void setPayerBank(String payerBank) {
        this.payerBank = payerBank;
    }

    public String getPayerCountryCode() {
        return payerCountryCode;
    }

    public void setPayerCountryCode(String payerCountryCode) {
        this.payerCountryCode = payerCountryCode;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getPayeeBank() {
        return payeeBank;
    }

    public void setPayeeBank(String payeeBank) {
        this.payeeBank = payeeBank;
    }

    public String getPayeeCountryCode() {
        return payeeCountryCode;
    }

    public void setPayeeCountryCode(String payeeCountryCode) {
        this.payeeCountryCode = payeeCountryCode;
    }

    public String getPaymentInstruction() {
        return paymentInstruction;
    }

    public void setPaymentInstruction(String paymentInstruction) {
        this.paymentInstruction = paymentInstruction;
    }

    public LocalDate getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(LocalDate executionDate) {
        this.executionDate = executionDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDateTime getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(LocalDateTime creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }
}
