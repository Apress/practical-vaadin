package com.apress.practicalvaadin.ch3;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("size")
public class SizeView extends Composite<Component> {

  @Override
  protected Component initContent() {
    var layout = new VerticalLayout();

    var button1 = new Button("I'm 100% wide");
    button1.setWidth("100%");

    var button2 = new Button("I'm 80% wide");
    button2.setWidth("80%");

    var button3 = new Button("I'm 300px wide");
    button3.setWidth("300px");

    var button4 = new Button("I'm 10em wide");
    button4.setWidth(10, Unit.EM);

    var button5 = new Button("I have undefined width");
    button5.setSizeUndefined();

    var button6 = new Button("Me too!");
    // button6 has undefined size by default

    layout.add(
        button1,
        button2,
        button3,
        button4,
        button5,
        button6
    );

    return layout;
  }

}
