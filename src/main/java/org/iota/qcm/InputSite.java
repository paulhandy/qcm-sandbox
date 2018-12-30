package org.iota.qcm;

public class InputSite implements Site {
  int length;

  public InputSite(int l) {
    length = l;
  }

  @Override
  public int size() {
    return length;
  }
}
