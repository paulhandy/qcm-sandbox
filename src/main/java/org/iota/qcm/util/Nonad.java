package org.iota.qcm.util;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Nonad implements Vector{
  short[] v;

  public Nonad(short[] s) {
    v = s;
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
    return this.v;
  }

  @Override
  public byte[] pentad() {
    throw new NotImplementedException();
  }
}
