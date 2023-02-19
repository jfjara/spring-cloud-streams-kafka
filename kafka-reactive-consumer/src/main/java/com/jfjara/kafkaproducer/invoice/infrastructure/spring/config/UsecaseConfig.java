package com.jfjara.kafkaproducer.invoice.infrastructure.spring.config;

import com.jfjara.kafkaproducer.invoice.application.ports.ProcessInvoice;
import com.jfjara.kafkaproducer.invoice.application.usecases.ProcessInvoiceUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsecaseConfig {

    @Bean
    public ProcessInvoice processInvoice() {
        return new ProcessInvoiceUseCase();
    }

}
