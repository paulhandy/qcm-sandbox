package org.iota.qcm.dataflow;

public interface Transform {
  int size();

  ThrowingBiConsumer<byte[],byte[]> function(int[] mapping);
}
