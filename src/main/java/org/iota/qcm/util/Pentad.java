package org.iota.qcm.util;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Pentad implements Vector {
  private byte[] v;

  public Pentad(byte[] in) {
    v = in;
  }

  @Override
  public Vector coded() {
    return null;
  }

  @Override
  public Vector subvec(int start, int length) {
    throw new NotImplementedException();
  }

  @Override
  public short[] nonad() {
    throw new NotImplementedException();
  }

  @Override
  public byte[] pentad() {
    return this.v;
  }
}
