package br.com.zup.transactions.service;

import br.com.zup.transactions.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaReceiver.class);

    @KafkaListener(topics = "${transactions.kafka.topic.name}", groupId = "${transactions.kafka.consumer.group.id}")
    public void receiveTransaction(Transaction transaction) {
        LOGGER.info(transaction.toString());
    }

}
