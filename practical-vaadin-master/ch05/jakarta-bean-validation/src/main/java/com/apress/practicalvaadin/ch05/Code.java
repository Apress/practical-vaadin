package com.apress.practicalvaadin.ch05;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Code {

  private Type type;

  @NotNull
  @NotBlank
  private String number;

  public Code(Type type, String number) {
    this.type = type;
    this.number = number;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

}
