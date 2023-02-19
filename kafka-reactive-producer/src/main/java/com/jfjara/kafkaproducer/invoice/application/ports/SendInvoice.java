package com.jfjara.kafkaproducer.invoice.application.ports;

import com.jfjara.kafkaproducer.invoice.domain.model.Invoice;
import reactor.core.publisher.Mono;

public interface SendInvoice {

    void execute(final Invoice invoice);

}
