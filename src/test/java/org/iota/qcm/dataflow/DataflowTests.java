package org.iota.qcm.dataflow;

import org.junit.Assert;
import org.junit.Test;

public class DataflowTests {
  @Test
  public void testReturnInput() {
    Lut eq, xor;
    Merge merge;
    Site eqSite, xorSite, mergeSite;
    byte[][][] eqlut, xorlut;
    int[] mappings;

    eqlut = new byte[4][4][4];
    eqlut[1][1][1] = 1;
    eqlut[2][2][2] = 2;
    eqlut[3][3][3] = 3;
    xorlut = new byte[4][4][4];
    xorlut[1][3][3] = 1;
    xorlut[3][1][3] = 1;
    xorlut[3][3][1] = 1;
    xorlut[2][3][3] = 2;
    xorlut[3][2][3] = 2;
    xorlut[3][3][2] = 2;

    eq = new Lut(eqlut);
    xor = new Lut(xorlut);
    merge = new Merge(1);

    mappings = java.util.stream.IntStream.range(0,3).toArray();
    mergeSite = new Site(merge, new Site[]{}, mappings);
    eqSite = new Site(eq, new Site[]{mergeSite}, mappings);
    xorSite = new Site(xor, new Site[]{mergeSite}, mappings);

    try {
      eqSite.send(new byte[]{1,1,1});
      xorSite.send(new byte[]{2,3,3});
      Assert.fail("The second collides");
    } catch (Exception e) {
    }

    eqSite.send(new byte[]{2,2,2});
    xorSite.send(new byte[]{2,3,3});

    Assert.assertArrayEquals(new byte[]{1}, mergeSite.val);

    /*
    byte[] val;
    ThingToRename in, out;
    in = new ThingToRename();
    out = new ThingToRename();

    in.sendTo(out, 0);
    in.sources[0] = out;
    out.dataArrivedRef.set(flow -> );
    */
  }
}
