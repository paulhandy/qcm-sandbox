package org.iota.qcm;

import org.iota.qcm.util.Vector;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

public class Knot {
  Transformation transformation;
  Knot[] subKnots;

  AtomicReference<Function<Vector, Vector>> fnRef = new AtomicReference<>(null);

  public Knot(Transformation branch) {
    transformation = branch;
  }

  public Vector apply(Vector in) {
    return fnRef.updateAndGet(vectorVectorFunction -> {
      if(vectorVectorFunction == null) {
        return vector -> vector;
      } else {
        return vectorVectorFunction;
      }
    }).apply(in);
  }
}
