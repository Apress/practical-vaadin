package com.apress.practicalvaadin.ch10;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("lumo-properties")
@CssImport("./custom-properties.css")
public class LumoPropertiesView extends Composite<Component> {

  @Override
  protected Component initContent() {
    DatePicker birthDate = new DatePicker(
        "When's your birth date?");
    Button send = new Button("Send", event -> Notification
        .show("Cool!", 3000, Position.BOTTOM_END));

    return new VerticalLayout(new H1("Custom Lumo properties"),
        birthDate, send);
  }

}
