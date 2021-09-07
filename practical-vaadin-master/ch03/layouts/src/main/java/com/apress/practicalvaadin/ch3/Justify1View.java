package com.apress.practicalvaadin.ch3;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("justify1")
public class Justify1View extends Composite<Component> {

  @Override
  protected Component initContent() {
    return new VerticalLayout(
        createLayout(FlexComponent.JustifyContentMode.START),
        createLayout(FlexComponent.JustifyContentMode.END),
        createLayout(FlexComponent.JustifyContentMode.CENTER)
    );
  }

  private Component createLayout(FlexComponent.JustifyContentMode justifyContentMode) {
    var layout = new HorizontalLayout(
        new Button(justifyContentMode.name())
    );
    layout.setWidthFull();
    layout.getStyle().set("border", "1px solid");
    layout.setJustifyContentMode(justifyContentMode);

    return layout;
  }


}
