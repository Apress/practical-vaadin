package com.apress.practicalvaadin.ch10;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("theme")
public class ThemeView extends Composite<Component> {

  @Override
  protected Component initContent() {
    return new VerticalLayout(new H1("Material theme"),
        new Paragraph("Welcome to the Material theme!"),
        new HorizontalLayout(
            new VerticalLayout(new DatePicker("DatePicker"),
                new Checkbox("Checkbox")),
            new VerticalLayout(
                new ComboBox<String>("ComboBox", "Option 1",
                    "Option 2"),
                new Button("Button", event -> Notification
                    .show("Notification")))));

  }

}
