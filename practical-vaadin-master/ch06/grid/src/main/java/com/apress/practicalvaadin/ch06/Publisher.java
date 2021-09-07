package com.apress.practicalvaadin.ch06;

public class Publisher {

  private String name;

  @Override
  public String toString() {
    return name;
  }

  public Publisher(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
