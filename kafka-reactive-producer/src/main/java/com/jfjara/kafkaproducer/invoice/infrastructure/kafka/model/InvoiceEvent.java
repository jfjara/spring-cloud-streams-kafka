package com.jfjara.kafkaproducer.invoice.infrastructure.kafka.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class InvoiceEvent {

    private Long id;
    private BigDecimal amount;
    private String reference;
    private Long customerId;

}
