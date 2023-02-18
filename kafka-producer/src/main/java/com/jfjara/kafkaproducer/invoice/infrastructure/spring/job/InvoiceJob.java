package com.jfjara.kafkaproducer.invoice.infrastructure.spring.job;

import com.jfjara.kafkaproducer.invoice.application.ports.SendInvoice;
import com.jfjara.kafkaproducer.invoice.domain.model.Invoice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

@Component
public class InvoiceJob {

    private final Logger logger = LoggerFactory.getLogger(InvoiceJob.class);

    @Autowired
    private SendInvoice sendInvoice;

    @Scheduled(cron = "*/5 * * * * *")
    public void sendInvoice() {
        final Invoice invoice = createRandomInvoice();
        logger.info("Start invoice job. Send a Invoice {}", invoice);
        sendInvoice.execute(invoice);
        logger.info("End invoice job. Invoice has been sent");
    }

    private Invoice createRandomInvoice() {
        Random random = new Random(1000);
        return Invoice.builder()
                .id(Math.abs(random.nextLong() +1L))
                .amount(BigDecimal.valueOf(Math.abs(random.nextDouble() + 1D)))
                .customerId(Math.abs(random.nextLong() + 1L))
                .reference(UUID.randomUUID().toString())
                .build();
    }
}
