package com.jfjara.kafkaproducer.invoice.infrastructure.kafka.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfjara.kafkaproducer.invoice.infrastructure.kafka.model.InvoiceEvent;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvoiceSerializer implements Serializer<InvoiceEvent> {

    private final Logger logger = LoggerFactory.getLogger(InvoiceSerializer.class);

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, InvoiceEvent data) {
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (JsonProcessingException exception) {
            logger.info("Error serializing invoice event: {}", exception.getMessage());
            throw new SerializationException(exception);
        }
    }
}
