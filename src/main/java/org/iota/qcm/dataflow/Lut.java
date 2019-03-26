package org.iota.qcm.dataflow;

public class Lut implements Transform {
  byte[][][] val;

  public Lut(byte[][][] bytes) {
    val = bytes;
  }

  private ThrowingBiConsumer<byte[], byte[]> map(int i, int j, int k, int l) {
    return (in, out) -> out[i] = val[in[j]][in[k]][in[l]];
  }

  @Override
  public int size() {
    return 1;
  }

  @Override
  public ThrowingBiConsumer<byte[], byte[]> function(int[] mapping) {
    ThrowingBiConsumer<byte[], byte[]> f = map(0, mapping[0], mapping[1], mapping[2]);
    for(int i = 1; i < mapping.length / 3; i++) {
      f = f.andThen(map(i, mapping[i * 3], mapping[i * 3 + 1], mapping[i * 3 + 2]));
    }
    return f;
  }
}
