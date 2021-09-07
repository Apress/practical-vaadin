package com.apress.practicalvaadin.ch10;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("custom-css")
@CssImport("./custom-styles.css")
public class CustomCss extends Composite<Component> {

  @Override
  protected Component initContent() {
    TextField name = new TextField("What's your name?");
    Button send = new Button("Send", event -> Notification
        .show("Nice to meet you, " + name.getValue()));

    return new VerticalLayout(new H1("Custom CSS example"),
        name, send);
  }

}
