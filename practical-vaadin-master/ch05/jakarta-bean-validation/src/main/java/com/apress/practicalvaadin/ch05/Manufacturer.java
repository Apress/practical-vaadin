package com.apress.practicalvaadin.ch05;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class Manufacturer {

  private String name;

  @Size(min = 8)
  private String phoneNumber;

  @Email
  private String email;

  public Manufacturer() {
  }

  public Manufacturer(String name, String phoneNumber, String email) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
