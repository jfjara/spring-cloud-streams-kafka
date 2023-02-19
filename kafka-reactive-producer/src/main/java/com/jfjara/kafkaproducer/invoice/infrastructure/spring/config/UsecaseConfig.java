package com.jfjara.kafkaproducer.invoice.infrastructure.spring.config;

import com.jfjara.kafkaproducer.invoice.application.ports.SendInvoice;
import com.jfjara.kafkaproducer.invoice.application.usecases.SendInvoiceUseCase;
import com.jfjara.kafkaproducer.invoice.infrastructure.kafka.repository.SendInvoiceKafkaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsecaseConfig {


    @Bean
    public SendInvoice sendInvoice(final SendInvoiceKafkaRepository repository) {
        return new SendInvoiceUseCase(repository);
    }
}
