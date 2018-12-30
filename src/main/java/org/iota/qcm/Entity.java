package org.iota.qcm;

import org.iota.qcm.util.Pentad;

public class Entity {
  private Branch branch;
  private Knot knot = null;

  public Entity(Branch b) {
    branch = b;
  }

  public byte[] run(byte[] in) {
    if (knot == null) {
      knot = branch.instance();
    }
    return knot.apply(new Pentad(in)).pentad();
  }

  public int inputLength() {
    return branch.inputLength();
  }

  public int outputLength() {
    return branch.outputLength();
  }
}
