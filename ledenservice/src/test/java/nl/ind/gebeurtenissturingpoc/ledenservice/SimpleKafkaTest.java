package nl.ind.gebeurtenissturingpoc.ledenservice;

  
  
import nl.ind.gebeurtenissturingpoc.ledenservice.model.LidAangemeldPayload;

import nl.ind.gebeurtenissturingpoc.ledenservice.model.LidGewijzigdPayload;

import nl.ind.gebeurtenissturingpoc.ledenservice.model.LidVerwijderdPayload;
  

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.rule.EmbeddedKafkaRule;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.util.AssertionErrors.assertEquals;

/**
 * Example of tests for kafka based on spring-kafka-test library
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleKafkaTest {
      
    private static final String LEDENACTIE_PUBLISH_TOPIC = "event.leden";
     
    @ClassRule
    public static EmbeddedKafkaRule embeddedKafka = new EmbeddedKafkaRule(1, false, 1);

    private static EmbeddedKafkaBroker embeddedKafkaBroker = embeddedKafka.getEmbeddedKafka();

    @DynamicPropertySource
    public static void kafkaProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.kafka.bootstrap-servers", embeddedKafkaBroker::getBrokersAsString);
    }

     
    Producer<Integer, Object> producer;
    
    @Before
    public void init() {
         
        Map<String, Object> producerConfigs = new HashMap<>(KafkaTestUtils.producerProps(embeddedKafkaBroker));
        producer = new DefaultKafkaProducerFactory<>(producerConfigs, new IntegerSerializer(), new JsonSerializer()).createProducer();
        
    }
      
    @Test
    public void ledenActieConsumerTest() throws InterruptedException {
        Integer key = 1;  
        Object payload = new Object();

        ProducerRecord<Integer, Object> producerRecord = new ProducerRecord<>(LEDENACTIE_PUBLISH_TOPIC, key, payload);
        producer.send(producerRecord);
        producer.flush();
        Thread.sleep(1_000);
    }
        
    
}
