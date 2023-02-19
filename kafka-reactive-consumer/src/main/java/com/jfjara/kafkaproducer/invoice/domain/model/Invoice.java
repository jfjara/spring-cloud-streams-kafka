package com.jfjara.kafkaproducer.invoice.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Builder(toBuilder = true)
@Getter
@ToString
public class Invoice {

    private Long id;
    private BigDecimal amount;
    private String reference;
    private Long customerId;

}
