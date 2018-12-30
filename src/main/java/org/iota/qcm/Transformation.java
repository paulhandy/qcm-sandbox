package org.iota.qcm;

import org.iota.qcm.util.Vector;

import java.util.function.Function;

public interface Transformation {
  Knot instance();
  int size();
}
