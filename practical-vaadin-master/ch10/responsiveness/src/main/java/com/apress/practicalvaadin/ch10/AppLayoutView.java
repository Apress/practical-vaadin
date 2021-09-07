package com.apress.practicalvaadin.ch10;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "app-layout", layout = BusinessAppLayout.class)
public class AppLayoutView extends Composite<Component> {

  @Override
  protected Component initContent() {
    return new VerticalLayout(new H1("Business Application"),
        new Button("Let's do business!",
            event -> Notification.show("Success!")));
  }

}
