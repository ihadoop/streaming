package stock;

import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.concurrent.TimeUnit;

public class StockSource implements SourceFunction<StockPrice> {
    @Override
    public void run(SourceContext<StockPrice> sourceContext) throws Exception {
        int i=10000;
        while(i>=0){
            sourceContext.collect(StockPrice.gen());
            i--;
            TimeUnit.MILLISECONDS.sleep(10);
        }
    }

    @Override
    public void cancel() {

    }
}
