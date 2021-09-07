package com.apress.practicalvaadin.ch3;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("grow")
public class GrowView extends Composite<Component> {

  @Override
  protected Component initContent() {
    return new VerticalLayout(
        createLayout(0d, 0d),
        createLayout(10d, 10d),
        createLayout(2d, 1d)
    );
  }

  private Component createLayout(Double grow1, Double grow2) {
    var button1 = new Button("" + grow1.intValue());
    var button2 = new Button("" + grow2.intValue());

    var layout = new HorizontalLayout(
        button1,
        button2
    );
    layout.setWidthFull();
    layout.setFlexGrow(grow1, button1);
    layout.setFlexGrow(grow2, button2);

    return layout;
  }

}
