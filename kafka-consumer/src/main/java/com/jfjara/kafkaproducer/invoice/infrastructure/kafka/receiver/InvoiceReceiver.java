package com.jfjara.kafkaproducer.invoice.infrastructure.kafka.receiver;

import com.jfjara.kafkaproducer.invoice.application.ports.ProcessInvoice;
import com.jfjara.kafkaproducer.invoice.domain.model.Invoice;
import com.jfjara.kafkaproducer.invoice.infrastructure.kafka.mapper.InvoiceMapper;
import com.jfjara.kafkaproducer.invoice.infrastructure.kafka.model.InvoiceEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class InvoiceReceiver {

    @Autowired
    private ProcessInvoice processInvoice;

    @Autowired
    private InvoiceMapper mapper;

    @Bean
    public Consumer<InvoiceEvent> invoice() {
        return event -> {
            final Invoice invoice = mapper.toModel(event);
            processInvoice.execute(invoice);
        };
    }

}
