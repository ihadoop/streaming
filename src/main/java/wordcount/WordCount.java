package wordcount;

import org.apache.flink.runtime.execution.Environment;
import org.apache.flink.streaming.api.scala.DataStream;
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment;

public class WordCount {

    public static void main(String[] args) {

        StreamExecutionEnvironment env  = StreamExecutionEnvironment.getExecutionEnvironment();

      DataStream<String> dataStream =  env.addSource();

        dataStream.flatMap().keyBy(0).sum(1).print();
    }

}
