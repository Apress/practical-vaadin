package com.apress.practicalvaadin.ch3;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.Route;

@Route("flex-wrap")
public class FlexWrapView extends Composite<Component> {

  @Override
  protected Component initContent() {
    var layout = new FlexLayout();
    for (int i = 1; i <= 13; i++) {
      layout.add(new Button("Button " + i));
    }

    layout.setFlexDirection(FlexLayout.FlexDirection.ROW);
    layout.setFlexWrap(FlexLayout.FlexWrap.WRAP);
    layout.setAlignContent(FlexLayout.ContentAlignment.SPACE_BETWEEN);
    layout.setSizeFull();

    return layout;
  }

}
