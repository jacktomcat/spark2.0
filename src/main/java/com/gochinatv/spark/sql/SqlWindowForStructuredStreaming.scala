package com.gochinatv.spark.sql

import org.apache.spark.sql.{DataFrame, SparkSession}


/**
  * <p>Created by jacktomcat on 2017/7/11.<p/>
  * <p>refer to :<p/>
  * https://databricks.com/blog/2016/08/15/how-to-use-sparksession-in-apache-spark-2-0.html
  *
  * https://www.iteblog.com/archives/1719.html
  *
  * http://blog.madhukaraphatak.com/introduction-to-spark-two-part-5/
  *
  */
object SqlWindowForStructuredStreaming {

  def main(args: Array[String]): Unit = {

    val sparkSession = SparkSession.builder().master("local[*]").appName("SparkSqlWindow").getOrCreate()

    /**
      * get a hiveContext
      *
      * val sparkSession =
      * SparkSession.builder().master("local[*]").appName("SparkSqlWindow").enableHiveSupport().getOrCreate()
      */

    val sqlContext = sparkSession.sqlContext
    val dataFrame = sqlContext.read
      .option("encoding","UTF-8")
      .option("header",true)
      .option("timestampFormat","yyyy-MM-dd HH:mm:ss")
      .csv("logs.csv")

    import org.apache.spark.sql.functions._

    /**
      * Using Spark SQL with SparkSession
      *  Through SparkSession, you can access all of the Spark SQL functionality as you would through SQLContext.
      *  In the code sample below, we create a table against which we issue SQL queries.
      */
    /*dataFrame.createOrReplaceTempView("logs")
    sparkSession.sql("select * from logs").show(1000)*/


    /**
      * Reading JSON Data with SparkSession API
      *  Like any Scala object you can use spark, the SparkSession object,
      *  to access its public methods and instance fields. I can read JSON or CVS or TXT file,
      *  or I can read a parquet table. For example, in this code snippet, we will read a JSON file of zip codes,
      *  which returns a DataFrame, a collection of generic Rows.
      */
    val result = dataFrame//.select(dataFrame("id"),dataFrame("name"),dataFrame("time"))
      .filter("id>0")
      .groupBy(dataFrame("id"),dataFrame("name"),window(dataFrame("time"),"1 minutes").as("time") )
      .agg((sum(dataFrame("value"))/sum(dataFrame("count"))).as("avg_value"))

    printWindow(result)

    /**
    val lines = sparkSession.readStream
      .format("socket")
      .option("host", "localhost")
      .option("port", 9999)
      .load()**/

    //sparkSession.read.format("").load().groupBy(window(dataFrame(""),""))

    //val worldCount = lines.as[String].flatMap(_.split(" ")).groupBy("").count();
    //worldCount.writeStream.outputMode("append").format("parquet")

  }


  def printWindow(windowDF:DataFrame) ={
    windowDF.sort("id","time.start").
      select("id","name","time.start","time.end","avg_value").
      show(truncate = false)
  }

}
