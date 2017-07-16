package com.gochinatv.spark.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Arrays;
import java.util.Properties;


/**
 *
 *
 *
 */
public class KafkaReceiveMessage {

	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.put("bootstrap.servers", "192.168.2.150:9092");
		props.put("group.id", "alarm_consumer");
		props.put("zookeeper.connect", "192.168.2.150:2181");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "com.gochinatv.spark.kafka.DeserializedMessage");
		KafkaConsumer<String, WrapperAppMessage> consumer = new KafkaConsumer<>(props);

		consumer.subscribe(Arrays.asList("NL_U_APP_ALARM_APP"));
		while (true) {
			ConsumerRecords<String, WrapperAppMessage> records = consumer.poll(100);
			for (ConsumerRecord<String, WrapperAppMessage> record : records){
                //Thread.sleep(1500L);
                WrapperAppMessage value = record.value();
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), value.toString());
			}
		}

		//case 2
		//发送带时间戳的message
		 /*producer.send(new ProducerRecord<String, String>("spark-test", 0, 1490608032358L, Integer.toString(100), Integer.toString(100)+"-jackjboss"));
		 producer.send(new ProducerRecord<String, String>("spark-test", 1, 1490608031358L, Integer.toString(200), Integer.toString(200)+"-jackjboss"));
		 producer.send(new ProducerRecord<String, String>("spark-test", 2, 1490608039358L, Integer.toString(300), Integer.toString(300)+"-jackjboss"));
		 producer.flush();
		 producer.close();*/

		//case 3
		//需要使用命令行创建topic并且指定分区数，同时发送消息至分区
		 /*while(true){
			 Thread.sleep(1000L);
		 producer.send(new ProducerRecord<String, String>("spark-test", 0, Integer.toString(100), Integer.toString(100)+"-jackjboss"));
		 producer.send(new ProducerRecord<String, String>("spark-test", 1, Integer.toString(200), Integer.toString(200)+"-jackjboss"));
		 producer.send(new ProducerRecord<String, String>("spark-test", 2, Integer.toString(300), Integer.toString(300)+"-jackjboss"));
		 i = i+1;
		 }*/
		//producer.flush();
		//producer.close();

	}

}
