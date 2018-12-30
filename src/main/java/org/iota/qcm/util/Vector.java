package org.iota.qcm.util;

public interface Vector {
  Vector coded();
  Vector subvec(int start, int length);
  short[] nonad();
  byte[] pentad();
}
