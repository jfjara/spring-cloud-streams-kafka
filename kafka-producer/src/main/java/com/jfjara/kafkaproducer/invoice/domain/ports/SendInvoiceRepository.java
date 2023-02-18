package com.jfjara.kafkaproducer.invoice.domain.ports;

import com.jfjara.kafkaproducer.invoice.domain.model.Invoice;

public interface SendInvoiceRepository {

    void send(final Invoice invoice);

}
