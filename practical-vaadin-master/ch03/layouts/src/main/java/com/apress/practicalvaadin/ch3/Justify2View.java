package com.apress.practicalvaadin.ch3;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("justify2")
public class Justify2View extends Composite<Component> {

  @Override
  protected Component initContent() {
    return new VerticalLayout(
        createLayout(FlexComponent.JustifyContentMode.BETWEEN),
        createLayout(FlexComponent.JustifyContentMode.AROUND),
        createLayout(FlexComponent.JustifyContentMode.EVENLY)
    );
  }

  private Component createLayout(FlexComponent.JustifyContentMode justifyContentMode) {
    var layout = new HorizontalLayout(
        new Button("1"),
        new Button("2"),
        new Button("3")
    );
    layout.setWidthFull();
    layout.getStyle().set("border", "1px solid");
    layout.setJustifyContentMode(justifyContentMode);
    layout.setSpacing(false);

    return new VerticalLayout(
        new Text(justifyContentMode.name() + ":"),
        layout
    );
  }

}
