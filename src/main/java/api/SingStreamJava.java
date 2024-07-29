package api;

import org.apache.avro.generic.GenericRecord;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

public class SingStreamJava {


    public static void main(String[] args) {


        StreamExecutionEnvironment executionEnvironment;
        //executionEnvironment.addSource(null).returns(new GenericRecord(null));
        DataStream<String> source = null;


        source.map(e->e).print();

        source.filter(new FilterFunction<String>() {
            @Override
            public boolean filter(String value) throws Exception {
                return false;
            }
        });


        source.flatMap(new FlatMapFunction<String, Object>() {
            @Override
            public void flatMap(String value, Collector<Object> out) throws Exception {
                out.collect(value);
            }
        });
    }



}
