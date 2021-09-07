package com.apress.practicalvaadin.ch05;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Product {

  @NotNull
  @NotBlank
  private String name;

  private Code code = new Code(Type.DRINK, "");

  private boolean available = true;

  private Manufacturer manufacturer = new Manufacturer("", "", "");

  public Product() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Code getCode() {
    return code;
  }

  public void setCode(Code code) {
    this.code = code;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  public Manufacturer getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(Manufacturer manufacturer) {
    this.manufacturer = manufacturer;
  }

}
