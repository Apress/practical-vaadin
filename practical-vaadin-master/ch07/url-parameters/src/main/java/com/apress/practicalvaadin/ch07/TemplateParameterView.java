package com.apress.practicalvaadin.ch07;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;

import java.util.Optional;

@Route("template-parameter/:value?")
public class TemplateParameterView extends Composite<Component>
    implements BeforeEnterObserver {

  private H1 text = new H1();

  @Override
  protected Component initContent() {
    return new VerticalLayout(text);
  }

  @Override
  public void beforeEnter(BeforeEnterEvent event) {
    Optional<String> value = event.getRouteParameters().get("value");
    setValue(value.orElse("(no value)"));
  }

  private void setValue(String value) {
    text.setText(value);
  }

}
