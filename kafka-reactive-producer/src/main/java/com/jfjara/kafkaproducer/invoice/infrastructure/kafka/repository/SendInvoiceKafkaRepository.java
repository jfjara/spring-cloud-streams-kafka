package com.jfjara.kafkaproducer.invoice.infrastructure.kafka.repository;

import com.jfjara.kafkaproducer.invoice.domain.model.Invoice;
import com.jfjara.kafkaproducer.invoice.domain.ports.SendInvoiceRepository;
import com.jfjara.kafkaproducer.invoice.infrastructure.kafka.mapper.InvoiceMapper;
import com.jfjara.kafkaproducer.invoice.infrastructure.kafka.model.InvoiceEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

@Service
public class SendInvoiceKafkaRepository implements SendInvoiceRepository {

    @Autowired
    private InvoiceMapper mapper;
    private Sinks.Many<InvoiceEvent> channel = Sinks.many().unicast().onBackpressureBuffer();

    public Sinks.Many getChannel() {
        return channel;
    }

    public void send(final Invoice invoice) {
        channel.emitNext(mapper.toEvent(invoice), Sinks.EmitFailureHandler.FAIL_FAST);
    }

}
