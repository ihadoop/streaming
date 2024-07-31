package stock;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.configuration.RestOptions;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class StockMain {
    public static void main(String[] args) throws Exception {

        Configuration configuration = new Configuration();
        configuration.setInteger(RestOptions.PORT,8082);
        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironmentWithWebUI(configuration);


        DataStream<StockPrice> dataStream = env.addSource(new StockSource());




        DataStream<StockPrice> maxDataStream  = dataStream.map(new MapFunction<StockPrice, StockPrice>() {
            @Override
            public StockPrice map(StockPrice value) throws Exception {
                value.setPrice(value.getPrice()*7);
                return value;
            }
        }).keyBy(new KeySelector<StockPrice, String>() {

            @Override
            public String getKey(StockPrice value) throws Exception {
                return value.getCode();
            }
        }).min("price");


        DataStream<StockPrice> filterDataStream  = dataStream.filter(new FilterFunction<StockPrice>() {
            @Override
            public boolean filter(StockPrice value) throws Exception {
                return false;
            }
        });


        env.execute("SocketWindowWordCountJava");
    }
}
