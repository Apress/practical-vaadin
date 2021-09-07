package com.apress.practicalvaadin.ch10;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

@Route("css-classes")
@CssImport("./custom-classes.css")
@CssImport(value = "./vaadin-grid.css", themeFor = "vaadin-grid")
public class CssClassesView extends Composite<Component> {

  @Override
  protected Component initContent() {
    var header = new Div(VaadinIcon.VAADIN_H.create(),
        new H1("Title"),
        new Anchor("https://vaadin.com?utm_source=apressbook",
            "Log out"));

    Grid<String> grid = new Grid<>(String.class);
    grid.setItems("item1", "item2", "item3", "");

    var content = new Div(grid);

    var layout = new Div();
    layout.add(header, content);

    layout.addClassName(getClass().getSimpleName());
    header.addClassName(getClass().getSimpleName() + "-header");
    content.addClassName(getClass().getSimpleName() + "-content");

    return layout;
  }

}
