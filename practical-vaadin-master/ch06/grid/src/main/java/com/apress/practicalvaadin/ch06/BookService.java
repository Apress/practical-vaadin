package com.apress.practicalvaadin.ch06;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BookService {

  private static List<Publisher> publishers;
  private static List<Book> books;

  private static void addVaadinBooksOnly() {
    String rawData =
        "Book of Vaadin|Marko Grönroos|Vaadin|Official Vaadin Book|\\" +
            "Learning Vaadin|Nicolas Fränkel|Packt\\" +
            "Vaadin 7 Cookbook|Jaroslav Holaň, Ondřej Kvasnovský|Packt\\" +
            "Vaadin UI Design by Example|Alejandro Duarte|Packt\\" +
            "Data-Centric Applications with Vaadin 8|Alejandro Duarte|Packt\\" +
            "Practical Vaadin|Alejandro Duarte|Apress";

    books = Arrays.stream(rawData.split("\\\\"))
        .map(entry -> new Book(
            entry.split("\\|")[0],
            entry.split("\\|")[1],
            new Publisher(entry.split("\\|")[2]),
            "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo."
        )).collect(Collectors.toList());
  }

  private static void addOneMillionBooks() {
    IntStream.range(0, 1000000)
        .mapToObj(i -> new Book(
            "Title " + i,
            "Author " + i,
            new Publisher("Publisher " + i),
            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."
        ))
        .forEach(books::add);
  }

  public static List<Book> findAll() {
    if (books == null) {
      addVaadinBooksOnly();
    }
    return Collections.unmodifiableList(books);
  }

  public static List<Book> findAll(int offset, int limit) {
    if (books == null || books.size() < 1000000) {
      addVaadinBooksOnly();
      addOneMillionBooks();
    }

    return books.subList(offset, offset + limit);
  }

  public static void increaseQuantity(Book book) {
    int newQuantity = book.getQuantity() + 1;
    if (newQuantity <= 50) {
      book.setQuantity(newQuantity);
    }
  }

}
