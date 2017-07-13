package com.gochinatv.spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by tingyun on 2017/7/12.
  */
object StreamingWindow {


  def main(args: Array[String]): Unit = {

    val topic = "log-click"
    val topic_group = "log-g01"

    val sparkSession = SparkSession.builder().appName("StreamingWindow2").master("local[*]").getOrCreate()
    val ssc = new StreamingContext(sparkSession.sparkContext, Seconds(1))

    val inputStream = KafkaUtils.createStream(ssc,"localhost:2181", topic_group, Map[String, Int](topic -> 1))
    //inputStream.map

  }
}
