package com.jfjara.kafkaproducer.invoice.domain.ports;

import com.jfjara.kafkaproducer.invoice.domain.model.Invoice;
import reactor.core.publisher.Sinks;

public interface SendInvoiceRepository {

    Sinks.Many getChannel();
    void send(final Invoice invoice);

}
