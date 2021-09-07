package com.apress.practicalvaadin.ch10;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("css")
@CssImport("./styles.css")
public class CssView extends Composite<Component> {

  @Override
  protected Component initContent() {
    Div menu = new Div(new RouterLink("Option 1", getClass()),
        new RouterLink("Option 2", getClass()),
        new RouterLink("Option 3", getClass()));

    menu.addClassName(getClass().getSimpleName() + "-menu");

    Div content = new Div(new H1("Hello!"), new Paragraph(
        "Try resizing the window to see the effect in the UI"));
    content
        .addClassName(getClass().getSimpleName() + "-content");

    Div layout = new Div(menu, content);
    layout.addClassName(getClass().getSimpleName());
    return layout;
  }

}
