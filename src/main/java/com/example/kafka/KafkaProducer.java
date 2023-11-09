package com.example.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.dto.OrderEvent;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class KafkaProducer {

	private NewTopic topic;

	private KafkaTemplate<String, OrderEvent> kafkaTemplate;

	public KafkaProducer(NewTopic topic, KafkaTemplate<String, OrderEvent> kafkaTemplate) {
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendEvent(OrderEvent orderEvent) {
		log.info("event is created for order event ::::: " + orderEvent);

		// create message

		Message<OrderEvent> message = MessageBuilder.withPayload(orderEvent).setHeader(KafkaHeaders.TOPIC, topic.name())
				.build();

		kafkaTemplate.send(message);

	}

}
