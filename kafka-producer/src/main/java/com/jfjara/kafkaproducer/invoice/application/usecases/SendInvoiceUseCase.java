package com.jfjara.kafkaproducer.invoice.application.usecases;

import com.jfjara.kafkaproducer.invoice.application.ports.SendInvoice;
import com.jfjara.kafkaproducer.invoice.domain.model.Invoice;
import com.jfjara.kafkaproducer.invoice.domain.ports.SendInvoiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendInvoiceUseCase implements SendInvoice {

    private final Logger logger = LoggerFactory.getLogger(SendInvoiceUseCase.class);

    private final SendInvoiceRepository repository;

    public SendInvoiceUseCase(final SendInvoiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(final Invoice invoice) {
        logger.info("Execute send invoice usecase. Send invoice {}", invoice);
        repository.send(invoice);
    }
}
