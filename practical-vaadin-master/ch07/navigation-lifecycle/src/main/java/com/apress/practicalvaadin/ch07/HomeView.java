package com.apress.practicalvaadin.ch07;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("")
public class HomeView extends Composite<Component> {

  @Override
  protected Component initContent() {
    return new VerticalLayout(
        new H1("Welcome!"),
        new RouterLink("Go to my data", DataView.class)
    );
  }

}
