package com.jfjara.kafkaproducer.invoice.infrastructure.kafka.repository;

import com.jfjara.kafkaproducer.invoice.domain.model.Invoice;
import com.jfjara.kafkaproducer.invoice.domain.ports.SendInvoiceRepository;
import com.jfjara.kafkaproducer.invoice.infrastructure.kafka.mapper.InvoiceMapper;
import com.jfjara.kafkaproducer.invoice.infrastructure.kafka.model.InvoiceEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class SendInvoiceKafkaRepository implements SendInvoiceRepository {

    @Autowired
    private StreamBridge streamBridge;

    @Autowired
    private InvoiceMapper mapper;

    @Override
    public void send(final Invoice invoice) {
        final InvoiceEvent event = mapper.toEvent(invoice);
        streamBridge.send("invoice-out-0", event);
    }

}
