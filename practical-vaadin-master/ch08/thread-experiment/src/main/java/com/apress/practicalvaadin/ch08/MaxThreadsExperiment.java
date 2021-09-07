package com.apress.practicalvaadin.ch08;

import java.util.concurrent.atomic.AtomicInteger;

public class MaxThreadsExperiment extends Thread {

  public static void main(String... args) {
    new MaxThreadsExperiment().start();
  }

  public static final AtomicInteger count = new AtomicInteger();

  @Override
  public void run() {
    try {
      System.out.println(count.incrementAndGet());
      new MaxThreadsExperiment().start();
      sleep(Long.MAX_VALUE);

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
