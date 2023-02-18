package com.jfjara.kafkaproducer.invoice.application.ports;

import com.jfjara.kafkaproducer.invoice.domain.model.Invoice;

public interface SendInvoice {

    void execute(final Invoice invoice);

}
