package org.iota.qcm.dataflow;

import java.util.function.BiConsumer;

@FunctionalInterface
public interface ThrowingBiConsumer<T,U> extends BiConsumer<T,U> {

  @Override
  default void accept(final T first, final U second) {
    try {
      acceptThrows(first, second);
    } catch (final Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  default ThrowingBiConsumer<T, U> andThen(BiConsumer<? super T, ? super U> after) {
    return (t, u) -> {
      accept(t,u);
      after.accept(t,u);
    };
  }

  void acceptThrows(T elem, U other) throws Exception;
}
