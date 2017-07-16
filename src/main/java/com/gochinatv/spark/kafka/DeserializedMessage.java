package com.gochinatv.spark.kafka;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Map;

/**
 * Created by jacktomcat on 17/7/14.
 */
public class DeserializedMessage implements Deserializer<WrapperAppMessage>{

    @Override
    public void configure(Map map, boolean b) {

    }

    @Override
    public WrapperAppMessage deserialize(String s, byte[] bytes) {
        //反序列化
        DatumReader<WrapperAppMessage> datumReader = new SpecificDatumReader<WrapperAppMessage>(WrapperAppMessage.getClassSchema());

        BinaryDecoder binaryDecoder = DecoderFactory.get().binaryDecoder(bytes, null);
        WrapperAppMessage message = new WrapperAppMessage();

        try {
            datumReader.read(message,binaryDecoder);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }

    @Override
    public void close() {

    }
}
