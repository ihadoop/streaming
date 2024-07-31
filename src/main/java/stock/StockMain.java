package stock;

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




        dataStream.keyBy(new KeySelector<StockPrice, String>() {

            @Override
            public String getKey(StockPrice value) throws Exception {
                return value.getCode();
            }
        }).max("price").print();





        env.execute("SocketWindowWordCountJava");
    }
}
