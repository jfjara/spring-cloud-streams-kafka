package com.jfjara.kafkaproducer.invoice.application.usecases;

import com.jfjara.kafkaproducer.invoice.application.ports.ProcessInvoice;
import com.jfjara.kafkaproducer.invoice.domain.model.Invoice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProcessInvoiceUseCase implements ProcessInvoice {

    private final Logger logger = LoggerFactory.getLogger(ProcessInvoiceUseCase.class);

    @Override
    public void execute(final Invoice invoice) {
        logger.info("Execute process invoice use case. Hi invoice {}", invoice);
    }
}
