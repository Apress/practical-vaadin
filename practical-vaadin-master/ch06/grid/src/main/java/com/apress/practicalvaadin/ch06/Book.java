package com.apress.practicalvaadin.ch06;

import java.util.concurrent.atomic.AtomicInteger;

public class Book {

  private static AtomicInteger nextId = new AtomicInteger(1);

  private Integer id;

  private String title;

  private String author;

  private Publisher publisher;

  private int quantity = (int) (Math.random() * (50));

  private String description;

  public Book(String title, String author, Publisher publisher, String description) {
    this.title = title;
    this.author = author;
    this.publisher = publisher;
    this.description = description;
    this.id = nextId.getAndIncrement();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Publisher getPublisher() {
    return publisher;
  }

  public void setPublisher(Publisher publisher) {
    this.publisher = publisher;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
