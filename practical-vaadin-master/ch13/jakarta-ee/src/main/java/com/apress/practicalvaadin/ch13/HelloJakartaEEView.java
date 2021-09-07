package com.apress.practicalvaadin.ch13;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("hello-jakarta-ee")
public class HelloJakartaEEView extends Composite<Component> {

  @Override
  protected Component initContent() {
    return new VerticalLayout(new Text("Hello Jakarta EE!"));
  }

}
