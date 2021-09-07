package com.apress.practicalvaadin.ch02;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("hello-world")
public class HelloWorldView extends VerticalLayout {

  public HelloWorldView() {
    add(new Paragraph("Hello, World!"));
  }

}
