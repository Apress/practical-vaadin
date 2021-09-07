package com.apress.practicalvaadin.ch06;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("sorting")
public class SortingView extends Composite<Component> {

  @Override
  protected Component initContent() {
    var grid = new Grid<Book>();
    grid.addColumn(Book::getTitle)
        .setHeader("Book")
        .setAutoWidth(true)
        .setComparator((book1, book2) ->
            book1.getTitle().compareToIgnoreCase(book2.getTitle()));

    grid.addColumn(book -> book.getPublisher().getName()).setHeader("Publisher");
    grid.addColumn(Book::getAuthor).setHeader("Author").setSortable(true);
    grid.addColumn(Book::getQuantity).setHeader("Quantity");

    List<Book> books = BookService.findAll();
    grid.setItems(books);

    return new VerticalLayout(grid);
  }

}
