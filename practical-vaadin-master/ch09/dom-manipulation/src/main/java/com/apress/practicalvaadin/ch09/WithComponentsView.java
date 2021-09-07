package com.apress.practicalvaadin.ch09;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.Route;

@Route("with-components")
public class WithComponentsView extends Div {
  
  public WithComponentsView() {
    setId("our-div");
    add(
        new H1("Component API example"),
        new Span("Greetings from the high-level API!")
    );
  }

}
