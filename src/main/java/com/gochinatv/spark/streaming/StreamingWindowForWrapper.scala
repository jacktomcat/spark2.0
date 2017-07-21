package com.gochinatv.spark.streaming

import com.gochinatv.spark.kafka.{DeserializedMessage, WrapperAppMessage}
import kafka.serializer.StringDecoder
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.functions.{sum, window}
import org.apache.spark.sql.{SQLContext, SparkSession}
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.joda.time.DateTime

/**
  * Created by jacktomcat on 2017/7/12.
  */

case class WrapperMessage(timestamp: String, count: Int, value: Float, agreeId: Int, cityId: Int, provinceId: Int, instanceId: Int, connectType: Int)

object StreamingWindowForWrapper {


  def main(args: Array[String]): Unit = {
    val topic = "NL_U_APP_ALARM_APP"
    val topic_group = "alarm_consumer"

    val sparkSession = SparkSession.builder().master("local[*]").appName("StreamingWindow2").getOrCreate()
    val ssc = new StreamingContext(sparkSession.sparkContext, Seconds(60))

    val storageLevel = StorageLevel.MEMORY_AND_DISK_2

    val kafkaParams = Map[String, String](
      ("bootstrap.servers" -> "localhost:9092"),
      ("group.id" -> topic_group),
      ("zookeeper.connect" -> "localhost:2181"),
      ("enable.auto.commit" -> "true"),
      ("auto.commit.interval.ms" -> "1000"),
      ("key.deserializer" -> "org.apache.kafka.common.serialization.StringDeserializer"),
      ("value.deserializer" -> "com.gochinatv.spark.streaming.WrapperDecoder")
    )

    val inputStream = KafkaUtils.createStream[String,WrapperAppMessage,StringDecoder,WrapperDecoder](ssc, kafkaParams, Map[String, Int]((topic -> 1)), storageLevel)
    val wrapperStream = inputStream.map(_._2).map(msg => WrapperMessage(new DateTime(msg.getTimestamp).toString("yyyy-MM-dd HH:mm:ss"), msg.getCount, msg.getValue, msg.getAgreeId, msg.getCityId, msg.getProvinceId, msg.getInstanceId, msg.getConnectType))

    val sqlContext = sparkSession.sqlContext
    import sqlContext.implicits._
    import org.apache.spark.sql.functions._
    wrapperStream.transform(message=>{
      /**message.toDF().createOrReplaceTempView("T_GO_LOG_MESSAGE")
      val df = sqlContext.sql("select * from T_GO_LOG_MESSAGE")**/

      val df = message.toDF()
      val result = df.filter("cityId>0").groupBy(df("cityId"),df("provinceId"),window(df("timestamp"),"1 minutes").as("time"))
          .agg((sum(df("value"))/sum(df("count"))).as("avg_value"))

      result.rdd
    }).print(100)

    //wrapperStream.print();

    ssc.start()
    ssc.awaitTermination()

  }
}
