package api;

import org.apache.flink.api.common.accumulators.IntCounter;
import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

public class WordRichFlatMap extends RichFlatMapFunction<String,String> {

    private IntCounter counter = new IntCounter(1);
    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);
        this.getRuntimeContext().addAccumulator("t",counter);
    }

    @Override
    public void close() throws Exception {
        super.close();
    }

    @Override
    public void flatMap(String value, Collector out) throws Exception {
        counter.add(1);
        for (String s : value.split(" ")) {
            out.collect(s);
        }
    }
}
