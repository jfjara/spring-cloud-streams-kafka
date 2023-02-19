package com.jfjara.kafkaproducer.invoice.application.ports;

import com.jfjara.kafkaproducer.invoice.domain.model.Invoice;

public interface ProcessInvoice {

    void execute(final Invoice invoice);

}
