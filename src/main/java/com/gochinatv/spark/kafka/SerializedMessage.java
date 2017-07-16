package com.gochinatv.spark.kafka;

import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * Created by jacktomcat on 17/7/14.
 */
public class SerializedMessage implements Serializer<WrapperAppMessage>{

    @Override
    public void configure(Map<String, ?> map, boolean b) {

    }

    @Override
    public byte[] serialize(String s, WrapperAppMessage wrapperAppMessage) {
        DatumWriter<WrapperAppMessage> datumWriter = new SpecificDatumWriter<>(wrapperAppMessage.getSchema());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BinaryEncoder binaryEncoder = EncoderFactory.get().binaryEncoder(outputStream, null);
        try {
            datumWriter.write(wrapperAppMessage, binaryEncoder);
            binaryEncoder.flush();//带缓冲区的binaryEncoder和直接directBinaryEncoder不一样，需要flush一下，否则字节数组没有数据
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] data = outputStream.toByteArray();
        return data;
    }

    @Override
    public void close() {

    }


}
