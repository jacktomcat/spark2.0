package com.gochinatv.spark

import com.gochinatv.spark.kafka.{DeserializedMessage, WrapperAppMessage}
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by jacktomcat on 2017/7/12.
  */

case class WrapperMessage(timestamp: Long, count: Int, value: Float, agreeId: Int, cityId: Int, provinceId: Int, instanceId: Int, connectType: Int)

object StreamingWindow {


  def main(args: Array[String]): Unit = {

    val topic = "NL_U_APP_ALARM_APP"
    val topic_group = "alarm_consumer"

    //val sparkSession = SparkSession.builder().appName("StreamingWindow2").master("local[*]").getOrCreate()
    //val ssc = new StreamingContext(sparkSession.sparkContext, Seconds(1))

    val conf = new SparkConf().setMaster("local[*]").setAppName("StreamingWindow2")
    val ssc = new StreamingContext(conf, Seconds(1))


    val storageLevel = StorageLevel.MEMORY_AND_DISK_2

    //[String, WrapperAppMessage, StringDeserializer, DeserializedMessage]
    val inputStream = KafkaUtils.createStream(ssc, Map[String, String]
      ("bootstrap.servers" -> "192.168.2.150:9092",
        "group.id" -> topic_group,
        "zookeeper.connect" -> "192.168.2.150:2181",
        "enable.auto.commit" -> "true",
        "auto.commit.interval.ms" -> "1000",
        "key.deserializer" -> "org.apache.kafka.common.serialization.StringDeserializer",
        "value.deserializer" -> "com.gochinatv.spark.kafka.DeserializedMessage"),
      Map[String, Int](topic -> 1), storageLevel)

//    val wrapperStream =
//      inputStream.map(_._2).map(msg => WrapperMessage(msg.getTimestamp, msg.getCount, msg.getValue, msg.getAgreeId, msg.getCityId, msg.getProvinceId, msg.getInstanceId, msg.getConnectType))

    val wrapperStream = inputStream.map(_._2.asInstanceOf[WrapperMessage])
    wrapperStream.print();

    ssc.start()
    ssc.awaitTermination()

  }
}
