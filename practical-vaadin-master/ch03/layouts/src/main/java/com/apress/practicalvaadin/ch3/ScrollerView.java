package com.apress.practicalvaadin.ch3;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("scroller")
public class ScrollerView extends Composite<Component> {

  @Override
  protected Component initContent() {
    VerticalLayout layout = new VerticalLayout();
    for (int i = 1; i <= 100; i++) {
      layout.add(new Button("Button " + i));
    }

    Scroller scroller = new Scroller(layout);
    scroller.setHeight("200px");
    scroller.getStyle().set("border", "1px solid");

    return scroller;
  }

}
