package com.apress.practicalvaadin.ch3;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("composition")
public class CompositionView extends Composite<Component> {

  // The Toolbar class could be moved outside the CompositionView class
  public class Toolbar extends Composite<Component> {

    @Override
    protected Component initContent() {
      return new HorizontalLayout(
          new Button("Button 1"),
          new Button("Button 2"),
          new Button("Button 3")
      );
    }

  }

  @Override
  protected Component initContent() {
    return new VerticalLayout(
        new Toolbar(),
        new Paragraph("Paragraph 1"),
        new Paragraph("Paragraph 2"),
        new Paragraph("Paragraph 3")
    );
  }

}
