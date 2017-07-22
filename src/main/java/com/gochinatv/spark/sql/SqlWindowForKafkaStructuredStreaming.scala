package com.gochinatv.spark.sql

import org.apache.spark.sql.{DataFrame, SparkSession}

import scala.util.parsing.json.JSON


/**
  *
  * 该类有BUG
  *
  */
object SqlWindowForKafkaStructuredStreaming {

  def main(args: Array[String]): Unit = {

    val sparkSession = SparkSession.builder().master("local[*]").appName("SqlWindowForKafkaStructuredStreaming").getOrCreate()

    /**
      * get a hiveContext
      *
      * val sparkSession =
      * SparkSession.builder().master("local[*]").appName("SparkSqlWindow").enableHiveSupport().getOrCreate()
      */
    //val sqlContext = sparkSession.sqlContext

    val dataFrame = sparkSession.readStream.format("kafka")
      .option("kafka.bootstrap.servers","localhost:9092")
      .option("subscribe","NL_U_APP_ALARM_APP_STRING")
      .option("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer")
      .option("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer")
      //.option("startingOffsets", "latest")
      .load()

    println(dataFrame.first().mkString)


    /**
      * Using Spark SQL with SparkSession
      *  Through SparkSession, you can access all of the Spark SQL functionality as you would through SQLContext.
      *  In the code sample below, we create a table against which we issue SQL queries.
      */

    /**
      * Reading JSON Data with SparkSession API
      *  Like any Scala object you can use spark, the SparkSession object,
      *  to access its public methods and instance fields. I can read JSON or CVS or TXT file,
      *  or I can read a parquet table. For example, in this code snippet, we will read a JSON file of zip codes,
      *  which returns a DataFrame, a collection of generic Rows.
      */

    /*val result = dataFrame.map[String](row=>row.getString(0)).map(JSON.parseFull(_)).map(_.get.asInstanceOf[scala.collection.immutable.Map[String, String]])
      .filter("id>0")
      .groupBy(dataFrame("id"),dataFrame("name"),window(dataFrame("time"),"1 minutes").as("time") )
      .agg((sum(dataFrame("value"))/sum(dataFrame("count"))).as("avg_value"))

    printWindow(result)*/

  }


  def printWindow(windowDF:DataFrame) ={
    windowDF.sort("id","time.start").
      select("id","name","time.start","time.end","avg_value").
      show(truncate = false)
  }

}
