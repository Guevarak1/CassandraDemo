package com.guevarak1.cassandrademo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class Sender {
    private  static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String payload) {
        LOGGER.info("Sending payload='{}'", payload);
        kafkaTemplate.send("library.request", payload);
    }
}
/*
*create topic
bin/kafka-topics.sh --create --bootstrap-server localhost:9092 \
--replication-factor 1 \
--partitions 1 \
--topic library.request

*list offsets from beginning
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 \
 --topic library.request \
 --from-beginning
 */