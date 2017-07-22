package com.gochinatv.spark.streaming

import com.gochinatv.spark.kafka.{DeserializedMessage, WrapperAppMessage}
import kafka.serializer.StringDecoder
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by jacktomcat on 2017/7/12.
  */

object StreamingWindowForString {


  def main(args: Array[String]): Unit = {

    val topic = "NL_U_APP_ALARM_APP_STRING"

    val conf = new SparkConf().setMaster("local[*]").setAppName("StreamingWindowForString")
    val ssc = new StreamingContext(conf, Seconds(1))

    //[String, String, StringDeserializer, StringDeserializer]

    val kafkaParams = Map[String, String](
      ("bootstrap.servers" -> "localhost:9092"),
      ("group.id" -> "alarm_consumer"),
      ("zookeeper.connect" -> "localhost:2181"),
      ("enable.auto.commit" -> "true"),
      ("auto.commit.interval.ms" -> "1000"),
      ("key.deserializer" -> "org.apache.kafka.common.serialization.StringDeserializer"),
      ("value.deserializer" -> "org.apache.kafka.common.serialization.StringDeserializer")
    )

    val topics = Map[String, Int]((topic -> 1))

    val inputStream:ReceiverInputDStream[(String,String)] = KafkaUtils.createStream[String,String,StringDecoder,StringDecoder](ssc,kafkaParams,topics,StorageLevel.MEMORY_ONLY_2)

    val wrapperStream = inputStream.map(_._2)
    wrapperStream.print();

    ssc.start()
    ssc.awaitTermination()

  }
}
