package com.jfjara.kafkaproducer.invoice.infrastructure.kafka.receiver;

import com.jfjara.kafkaproducer.invoice.application.ports.ProcessInvoice;
import com.jfjara.kafkaproducer.invoice.domain.model.Invoice;
import com.jfjara.kafkaproducer.invoice.infrastructure.kafka.mapper.InvoiceMapper;
import com.jfjara.kafkaproducer.invoice.infrastructure.kafka.model.InvoiceEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

@Component
public class InvoiceReceiver {

    @Autowired
    private ProcessInvoice processInvoice;

    @Autowired
    private InvoiceMapper mapper;

    @Bean
    public Consumer<Flux<InvoiceEvent>> invoice() {
        return event -> {
            event.concatMap(i -> {
                final Invoice invoice = mapper.toModel(i);
                processInvoice.execute(invoice);
                return Mono.empty();
            }).subscribe();
        };
    }

}
