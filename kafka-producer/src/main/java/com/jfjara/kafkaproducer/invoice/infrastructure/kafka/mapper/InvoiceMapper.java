package com.jfjara.kafkaproducer.invoice.infrastructure.kafka.mapper;

import com.jfjara.kafkaproducer.invoice.domain.model.Invoice;
import com.jfjara.kafkaproducer.invoice.infrastructure.kafka.model.InvoiceEvent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    InvoiceEvent toEvent(final Invoice invoice);

}
