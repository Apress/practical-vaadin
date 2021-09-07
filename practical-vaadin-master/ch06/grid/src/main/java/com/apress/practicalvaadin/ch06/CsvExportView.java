package com.apress.practicalvaadin.ch06;

import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.util.Comparator;
import java.util.List;

@Route("csv-export")
public class CsvExportView extends Composite<Component> {

  @Override
  protected Component initContent() {
    var grid = new Grid<Book>();
    grid.addColumn(Book::getTitle).setHeader("Book").setAutoWidth(true).setSortable(true);
    grid.addColumn(book -> book.getPublisher().getName()).setHeader("Publisher").setSortable(true);
    grid.addColumn(Book::getAuthor).setHeader("Author").setSortable(true);
    grid.addComponentColumn(
        book -> new ProgressBar(0, 50, book.getQuantity())
    ).setHeader("Quantity")
        .setSortable(true)
        .setComparator(Comparator.comparingInt(Book::getQuantity));
    grid.setItemDetailsRenderer(
        new ComponentRenderer<>(book -> new VerticalLayout(
            new Text(book.getDescription()),
            new Button("Quantity", VaadinIcon.ARROW_UP.create(), event -> {
              BookService.increaseQuantity(book);
              updateGrid(grid);
              grid.select(book);
            })
        ))
    );

    updateGrid(grid);

    var streamResource = new StreamResource("books.csv",
        () -> {
          try {
            var books = grid.getGenericDataView().getItems();
            StringWriter output = new StringWriter();
            var beanToCsv = new StatefulBeanToCsvBuilder<Book>(output)
                .withIgnoreField(Book.class, Book.class.getDeclaredField("id"))
                .withIgnoreField(Book.class, Book.class.getDeclaredField("nextId"))
                .build();
            beanToCsv.write(books);
            return new ByteArrayInputStream(output.toString().getBytes());

          } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
          }
        }
    );

    var download = new Anchor(streamResource, "Download");

    return new VerticalLayout(download, grid);
  }

  private void updateGrid(Grid<Book> grid) {
    List<Book> books = BookService.findAll();
    grid.setItems(books);
  }

}
