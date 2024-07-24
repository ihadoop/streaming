package api

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment, createTypeInformation}

object SingStream {

  val ds:DataStream[String] = null;
   val  env = StreamExecutionEnvironment.getExecutionEnvironment
  env.setParallelism(2)

  val ds1 = ds.map{_.toDouble}
   val ds2 = ds.map{_.toDouble}
  ds2.setParallelism(2)

  ds.filter{_.toInt>1}

  ds.flatMap{_.split(" ")}

  ds.flatMap{e=>e.split(" ")}

  ds.keyBy("name").reduce{(a1,a2)=>a1+a2}

  ds1.union(ds2)
  ds.connect(ds1)
}
