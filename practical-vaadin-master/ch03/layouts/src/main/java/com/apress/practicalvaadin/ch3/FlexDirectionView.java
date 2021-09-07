package com.apress.practicalvaadin.ch3;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.Route;

@Route("flex-direction")
public class FlexDirectionView extends Composite<Component> {

  @Override
  protected Component initContent() {
    var button1 = new Button("1");
    var button2 = new Button("2");
    var button3 = new Button("3");

    var layout = new FlexLayout(
        button1,
        button2,
        button3
    );
    layout.setFlexDirection(FlexLayout.FlexDirection.ROW_REVERSE);

    return layout;
  }

}
