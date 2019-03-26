package org.iota.qcm.dataflow;

import org.iota.qcm.Branch;
import org.iota.qcm.Site;
import org.iota.qcm.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;

/*
Initially, we start a dataflow site with a presumption that it must be compiled.
Thus an invocation, or otherwise a data arrived event on a given dataflow site
would indicate that this site is now ready to be compiled.

So it compiles this site according to the instructions given,
creates the sources it is supposed to have,
and initializes these sources each to compile upon data arrival.

So a dataflow site is first created as a self-compiling definition site,
upon which entry it compiles and executes.
 */

public class DFlow implements DataArrivedListener, Site {
  DFlow[] children;
  DFlow[] parents;
  byte[] lut;
  int size;

  AtomicReference<BiConsumer<Vector, Vector>> fnRef = new AtomicReference<>(null);

  List<DataArrivedListener> dataArrivedListeners = new ArrayList<>();

  // the arrival to a particular site in a branch
  public DFlow(DFlow parent) {

  }

  // the creation of a new branch
  public DFlow(Branch definition) {

  }

  /*
   * Creates a new dataflow site, this one for the
   */
  public DFlow(DFlow[] p, DFlow[] c) {

  }

  public void addDataArrivedEventListener(DataArrivedListener eventListener) {
    dataArrivedListeners.add(eventListener);
  }

  @Override
  public void dataArrived() {
    // determine which sub-arrays received data.
    // send them data.
  }

  @Override
  public int size() {
    return size;
  }
}
