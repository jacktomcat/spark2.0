package com.gochinatv.spark.kafka;

import java.util.Date;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;


/**
 *
 * 创建消息 topic
 * kafka-topics.bat --create --topic spark-test --zookeeper localhost:2181 --partitions 3 --replication-factor 1
 *
 * 查看消息topic
 * kafka-topics.bat --describe --zookeeper localhost:2181 --topic spark-test
 *
 *
 */
public class KafkaSendMessage {

	public static String servers="localhost:9092";

	public static void main(String[] args) throws Exception {
		sendStringMessage();
		//sendWrapperMessage();
	}


	public static void  sendStringMessage() throws Exception{
		Properties props = new Properties();
		props.put("bootstrap.servers", servers);
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<>(props);

		//没有任何分区，默认1个分区，发送消息
		int i=0;
		while(i<1000){
			Thread.sleep(1000L);
			String message = "zhangsan"+i;
			producer.send(new ProducerRecord<>("NL_U_APP_ALARM_APP_STRING",message));
			i++;
			producer.flush();
		}
		producer.close();
	}


	public static void  sendWrapperMessage() throws Exception {
		Properties props = new Properties();
		props.put("bootstrap.servers", servers);
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "com.gochinatv.spark.kafka.SerializedMessage");
		Producer<String, WrapperAppMessage> producer = new org.apache.kafka.clients.producer.KafkaProducer<>(props);

		//case 1:
		//没有任何分区，默认1个分区，发送消息
		int i=0;
		while(i<1000){
			Thread.sleep(1000L);
			WrapperAppMessage message = new WrapperAppMessage();
			message.setAgreeId((i+1)%5);
			message.setCityId((i+1)%3);
			message.setConnectType((i+1)%4);
			message.setCount((i+100)%10);
			message.setInstanceId((i+1)%6);
			message.setProvinceId((i+1)%4);
			message.setTimestamp(System.currentTimeMillis());
			message.setValue((float)((i+200)%4));
			producer.send(new ProducerRecord<>("NL_U_APP_ALARM_APP",message));
			System.out.println(message.toString());
			i++;
			producer.flush();
		}
		producer.close();
	}

}
