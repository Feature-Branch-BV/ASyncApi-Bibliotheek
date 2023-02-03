package nl.ind.gebeurtenissturingpoc.ledenviewservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
    
import nl.ind.gebeurtenissturingpoc.ledenviewservice.model.LidAangemeldPayload;
import nl.ind.gebeurtenissturingpoc.ledenviewservice.model.LidGewijzigdPayload;
import nl.ind.gebeurtenissturingpoc.ledenviewservice.model.LidVerwijderdPayload;

@Service
public class MessageHandlerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageHandlerService.class);

    
    
    @KafkaListener(topics = "event.leden", groupId = "ledenviewservice")
    public void lidAangemeld(@Payload Object payload,
                       @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) Integer key,
                       @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                       @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long timestamp) {
        LOGGER.info("Key: " + key + ", Payload: " + payload.toString() + ", Timestamp: " + timestamp + ", Partition: " + partition);
    }
    

}
