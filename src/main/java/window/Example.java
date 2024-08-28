package window;

import org.apache.flink.api.common.functions.AggregateFunction;
import org.apache.flink.api.common.functions.JoinFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.WindowedStream;
import org.apache.flink.streaming.api.functions.co.ProcessJoinFunction;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.SlidingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.evictors.TimeEvictor;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.triggers.Trigger;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

public class Example {
    public static void main(String[] args) {

        StreamExecutionEnvironment env;
        DataStream<Object> dataStream = null;
        //time-based

        dataStream.keyBy(0).window(TumblingEventTimeWindows.of(Time.minutes(10)));

        dataStream.keyBy(0).window(TumblingProcessingTimeWindows.of(Time.minutes(10)));


        //sliding

        dataStream.keyBy(0).window(SlidingEventTimeWindows.of(Time.seconds(10),Time.seconds(1)));

        dataStream.keyBy(0).window(SlidingEventTimeWindows.of(Time.minutes(10),Time.seconds(1)));
        //deal with
        WindowedStream<Object,Object, TimeWindow> windowedStream = null;
        //windowedStream.reduce
        windowedStream.reduce(new ReduceFunction<Object>() {
            @Override
            public Object reduce(Object value1, Object value2) throws Exception {
                return null;
            }
        });

        windowedStream.aggregate(new AggregateFunction<Object, Object, Object>() {
            @Override
            public Object createAccumulator() {
                return null;
            }

            @Override
            public Object add(Object value, Object accumulator) {
                return null;
            }

            @Override
            public Object getResult(Object accumulator) {
                return null;
            }

            @Override
            public Object merge(Object a, Object b) {
                return null;
            }
        });


        windowedStream.process(new ProcessWindowFunction<Object, Object, Object, TimeWindow>() {
            @Override
            public void process(Object o, ProcessWindowFunction<Object, Object, Object, TimeWindow>.Context context, Iterable<Object> iterable, Collector<Object> collector) throws Exception {
            }
        });
        windowedStream.evictor(new TimeEvictor(10));
        //trigger

        //join
        DataStream<Tuple2<String,Integer>> input1 = null;
        DataStream<Tuple2<String,Integer>> input2 = null;

        DataStream<String> joined = input1.join(input2).where(s->s.f0).equalTo(s->s.f0).window(TumblingProcessingTimeWindows.of(Time.minutes(1))).apply(new JoinFunction<Tuple2<String, Integer>, Tuple2<String, Integer>, String>() {
            @Override
            public String join(Tuple2<String, Integer> first, Tuple2<String, Integer> second) throws Exception {
                return null;
            }
        });

        DataStream<String> join = input1.keyBy(0).intervalJoin(input2.keyBy(0)).between(Time.seconds(-5),Time.seconds(5)).upperBoundExclusive().lowerBoundExclusive().process(new ProcessJoinFunction<Tuple2<String, Integer>, Object, String>() {
            @Override
            public void processElement(Tuple2<String, Integer> left, Object right, ProcessJoinFunction<Tuple2<String, Integer>, Object, String>.Context ctx, Collector<String> out) throws Exception {

            }
        });
    }
}
