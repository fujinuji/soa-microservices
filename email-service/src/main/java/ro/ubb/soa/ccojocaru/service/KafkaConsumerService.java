package ro.ubb.soa.ccojocaru.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ro.ubb.soa.ccojocaru.model.SendEmailOrder;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "order-email", groupId = "soa")
    public void consumer(final ConsumerRecord<String, SendEmailOrder> consumerRecord) {
        SendEmailOrder sendEmailOrder = consumerRecord.value();
        System.out.println(sendEmailOrder.getEmail());
    }
}
