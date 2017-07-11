package com.gochinatv.spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}


/**
  * Created by jacktomcat on 2017/7/11.
  */
object SqlWindow {

  def main(args: Array[String]): Unit = {
    // val sparkConf = new SparkConf().setAppName("SparkSqlWindow").setMaster("local[*]")
    // val sc = new SparkContext(sparkConf)

    val sparkSession = SparkSession.builder().master("local[*]").appName("SparkSqlWindow").getOrCreate()
    val sqlContext = sparkSession.sqlContext
    val dataFrame = sqlContext.read
      .option("encoding","UTF-8")
      .option("header",true)
      .option("timestampFormat","yyyy-MM-dd HH:mm:ss")
      .csv("d:/logs.csv")

    import org.apache.spark.sql.functions._

    dataFrame//.select(dataFrame("id"),dataFrame("name"),dataFrame("time"))
      .filter("id>1")
      .groupBy(dataFrame("id"),dataFrame("name"),dataFrame("time"))
      .agg(sum(dataFrame("value"))/sum(dataFrame("count"))).show(1000)

  }

}
