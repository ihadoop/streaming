package stock;

import org.apache.flink.streaming.api.functions.source.SourceFunction;

public class StockSource implements SourceFunction<StockPrice> {
    @Override
    public void run(SourceContext<StockPrice> sourceContext) throws Exception {

    }

    @Override
    public void cancel() {

    }
}
