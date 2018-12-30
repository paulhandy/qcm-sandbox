package org.iota.qcm.util;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Bct implements Vector {
  byte[] b;

  @Override
  public Vector coded() {
    return this;
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
