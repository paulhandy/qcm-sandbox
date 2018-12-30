package org.iota.qcm.util;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Polyvec implements Vector{
  private Vector[] vectors;

  @Override
  public Vector coded() {
    throw new NotImplementedException();
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
    throw new NotImplementedException();
  }
}
