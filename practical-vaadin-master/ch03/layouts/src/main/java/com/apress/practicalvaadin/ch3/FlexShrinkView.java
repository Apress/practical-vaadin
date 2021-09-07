package com.apress.practicalvaadin.ch3;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.Route;

@Route("flex-shrink")
public class FlexShrinkView extends Composite<Component> {

  @Override
  protected Component initContent() {
    var button1 = new Button("1");
    var button2 = new Button("2");
    button1.setWidth("200px");
    button2.setWidth("200px");

    var layout = new FlexLayout(
        button1,
        button2
    );

    layout.getStyle().set("border", "1px solid");
    layout.setWidth("300px");
    layout.setFlexShrink(1d, button1);
    layout.setFlexShrink(2d, button2);

    return layout;
  }

}
