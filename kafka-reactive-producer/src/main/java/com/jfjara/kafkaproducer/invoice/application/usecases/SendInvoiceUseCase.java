package com.jfjara.kafkaproducer.invoice.application.usecases;

import com.jfjara.kafkaproducer.invoice.application.ports.SendInvoice;
import com.jfjara.kafkaproducer.invoice.domain.model.Invoice;
import com.jfjara.kafkaproducer.invoice.domain.ports.SendInvoiceRepository;
import reactor.core.publisher.Mono;

public class SendInvoiceUseCase implements SendInvoice {

    private final SendInvoiceRepository sendInvoiceRepository;

    public SendInvoiceUseCase(final SendInvoiceRepository sendInvoiceRepository) {
        this.sendInvoiceRepository = sendInvoiceRepository;
    }

    @Override
    public void execute(final Invoice invoice) {
        sendInvoiceRepository.send(invoice);
    }
}
