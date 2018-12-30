package org.iota.qcm;

import org.junit.Assert;
import org.junit.Test;

public class ExecutionTests {
  @Test
  public void testPassthrough() {
    Entity entity;
    Branch branch;
    byte[] in, out, exp;

    exp = new byte[]{22};
    in = new byte[]{22};

    Site inSite = new InputSite(4);
    Site outSite = new TransformSite(new Merge(new Site[]{inSite}));
    branch = new Branch(new Site[]{inSite}, new TransformSite[0], new Site[]{outSite}, new TransformSite[0]);
    entity = new Entity(branch);

    out = entity.run(in);

    Assert.assertArrayEquals(exp, out);
  }
}
