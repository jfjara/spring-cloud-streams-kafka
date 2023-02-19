package com.jfjara.kafkaproducer.invoice.infrastructure.kafka.repository;

import com.jfjara.kafkaproducer.invoice.infrastructure.kafka.model.InvoiceEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Configuration
public class Sender {
    @Autowired
    SendInvoiceKafkaRepository producerService;

    @Bean
    public Supplier<Flux<InvoiceEvent>> invoice() {
        return () -> producerService.getChannel().asFlux();
    }

}
