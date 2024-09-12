package checkpoint;

import org.apache.flink.runtime.state.filesystem.FsStateBackend;
import org.apache.flink.runtime.state.hashmap.HashMapStateBackend;
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment;

public class Demo {
    public static void main(String[] args) {
        StreamExecutionEnvironment env = null;

        env.setStateBackend(new HashMapStateBackend());
        env.getCheckpointConfig().setCheckpointStorage("hdfs://checkpoints");

    }
}
