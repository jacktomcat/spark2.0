package com.gochinatv.spark.streaming

import java.io.IOException

import com.gochinatv.spark.kafka.WrapperAppMessage
import kafka.serializer.Decoder
import kafka.utils.VerifiableProperties
import org.apache.avro.io.{BinaryDecoder, DatumReader, DecoderFactory}
import org.apache.avro.specific.SpecificDatumReader

/**
  * Created by tingyun on 2017/7/21.
  */
class WrapperDecoder(props: VerifiableProperties = null)  extends Decoder[WrapperAppMessage]{

       override def fromBytes(bytes: Array[Byte]): WrapperAppMessage = {
         //反序列化
         val datumReader: DatumReader[WrapperAppMessage] = new SpecificDatumReader[WrapperAppMessage](WrapperAppMessage.getClassSchema)
         val binaryDecoder: BinaryDecoder = DecoderFactory.get.binaryDecoder(bytes, null)
         val message: WrapperAppMessage = new WrapperAppMessage
         try {
           datumReader.read(message, binaryDecoder)
         }catch {
           case ex: IOException => {
             ex.printStackTrace()
           }
             message
         }

       }
}
