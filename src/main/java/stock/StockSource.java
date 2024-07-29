package stock;

import org.apache.flink.streaming.api.functions.source.SourceFunction;

public class StockSource implements SourceFunction<StockPrice> {
    @Override
    public void run(SourceContext<StockPrice> sourceContext) throws Exception {

        sourceContext.collect(StockPrice.gen());
    }

    @Override
    public void cancel() {

    }
}
