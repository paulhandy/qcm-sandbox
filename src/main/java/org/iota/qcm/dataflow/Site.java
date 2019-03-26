package org.iota.qcm.dataflow;

import java.util.function.BiConsumer;

public class Site {
  byte[] val;
  private Transform op;
  private BiConsumer<byte[], byte[]> f;
  private Site[] dest;

  public Site(Transform transform, Site[] destinations, int[] mapping) {
    op = transform;
    val = new byte[op.size()];
    dest = destinations;
    f = op.function(mapping);
    java.util.stream.IntStream.range(0, dest.length).forEach(i -> {
      f = f.andThen((in, vec) -> dest[i].send(vec));
    });
    for(Site d: dest) {
      f = f.andThen((i, v) -> d.send(v));
    }
  }

  public void send(byte[] in) {
    f.accept(in, val);
  }
}
