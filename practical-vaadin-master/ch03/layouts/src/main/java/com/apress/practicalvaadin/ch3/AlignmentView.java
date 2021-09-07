package com.apress.practicalvaadin.ch3;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("alignment")
public class AlignmentView extends Composite<Component> {

  @Override
  protected Component initContent() {
    var button1 = new Button("Center");
    var button2 = new Button("Start");
    var button3 = new Button("End");

    // try changing the following to HorizontalLayout
    // and call setHeightFull()
    var buttons = new VerticalLayout(
        button1,
        button2,
        button3
    );

    buttons.setAlignSelf(FlexComponent.Alignment.CENTER, button1);
    buttons.setAlignSelf(FlexComponent.Alignment.START, button2);
    buttons.setAlignSelf(FlexComponent.Alignment.END, button3);

    return buttons;
  }

}
