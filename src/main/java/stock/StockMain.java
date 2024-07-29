package stock;

import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStream;

public class StockMain {
    public static void main(String[] args) {

        DataStream<StockPrice> dataStream = null;




        dataStream.keyBy(new KeySelector<StockPrice, String>() {

            @Override
            public String getKey(StockPrice value) throws Exception {
                return value.getDateId()+"_"+value.getCode();
            }
        }).max("price").print();




    }
}
