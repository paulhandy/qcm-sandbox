package org.iota.qcm;

public class Merge implements Transformation{
  private Site[] sites;
  private int length = -1;

  public Merge(Site[] s) {
    sites = s;
  }

  @Override
  public Knot instance() {
    return new Knot(this);
  }

  @Override
  public int size() {
    int o;
    if(length < 0) {
      for(Site s: sites) {
        o = s.size();
        if(o != length) {
          if(length < 0) {
            length = o;
          } else {
            throw new RuntimeException("merged sizes do not match");
          }
        }
      }
    }
    return length;
  }
}
