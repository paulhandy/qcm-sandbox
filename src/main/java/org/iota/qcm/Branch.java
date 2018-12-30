package org.iota.qcm;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;

public class Branch implements Transformation{
  Site[] input, body, output, latch;

  public Branch(Site[] in, Site[] bd, Site[] out, Site[] lat) {
    input = in;
    body = bd;
    output = out;
    latch = lat;
  }

  public int inputLength() {
    throw new NotImplementedException();
  }

  public int outputLength() {
    throw new NotImplementedException();
  }

  @Override
  public Knot instance() {
    return new Knot(this);
  }

  @Override
  public int size() {
    return Arrays.stream(output).map(Site::size).reduce(0, Math::addExact);
  }
}
