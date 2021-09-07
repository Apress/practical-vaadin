package com.apress.practicalvaadin.ch09;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.router.Route;

@Route("creating-dom-elements")
public class CreatingDomElementsView extends Div {

  public CreatingDomElementsView() {
    Element div = getElement();
    div.setAttribute("id", "our-div");

    Element h1 = new Element("h1");
    h1.setText("Element API example");
    div.appendChild(h1);

    Element span = ElementFactory.createSpan();
    span.setText("Greetings from the low-level API!");
    div.appendChild(span);
  }

}
