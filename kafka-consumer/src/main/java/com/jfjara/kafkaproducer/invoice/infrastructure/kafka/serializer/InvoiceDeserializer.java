package com.jfjara.kafkaproducer.invoice.infrastructure.kafka.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfjara.kafkaproducer.invoice.infrastructure.kafka.model.InvoiceEvent;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class InvoiceDeserializer implements Deserializer<InvoiceEvent> {

    private final Logger logger = LoggerFactory.getLogger(InvoiceDeserializer.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public InvoiceEvent deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(new String(data), InvoiceEvent.class);
        } catch (IOException e) {
            logger.error("Error deserializing invoice event");
            throw new SerializationException(e);
        }
    }

}
