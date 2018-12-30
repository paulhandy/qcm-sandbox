package org.iota.qcm;

public class TransformSite implements Site {
  Transformation transformation;

  public TransformSite(Transformation t) {
    transformation = t;
  }

  @Override
  public int size() {
    return transformation.size();
  }
}
