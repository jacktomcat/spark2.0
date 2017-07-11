package com.gochinatv.spark

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by jacktomcat on 2017/7/11.
  */
object SqlWindow {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("SparkSqlWindow").setMaster("local[*]")
    val sc = new SparkContext(sparkConf)

  }

}
