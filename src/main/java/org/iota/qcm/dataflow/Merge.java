package org.iota.qcm.dataflow;

import java.util.function.BiConsumer;

public class Merge implements Transform {
  final int size;

  public Merge(int size) {
    this.size = size;
  }

  private ThrowingBiConsumer<byte[], byte[]> merge(final int i, final int j) {
    return (in, out) -> {
      if(in[j] != 0) {
        if (out[i] != 0 && out[i] != in[j]) {
          throw new CollidingDataException();
        }
        out[i] = in[j];
      }
    };
  }

  @Override
  public int size() {
    return size*4;
  }

  @Override
  public ThrowingBiConsumer<byte[], byte[]> function(int[] mapping) {
    ThrowingBiConsumer<byte[], byte[]> f = merge(0,mapping[0]);

    for(int j = 1; j < size; j ++) {
      f = f.andThen(merge(0, j));
    }
    /*
    for(int i = 1; i < numberToMerge; i++) {
      for(int j = 1; j < numberToMerge; j ++) {
        f = f.andThen(merge(i, j*size + i));
      }
    }
    */
    return f;
  }
}
