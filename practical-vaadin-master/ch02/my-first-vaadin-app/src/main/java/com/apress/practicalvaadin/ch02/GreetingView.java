package com.apress.practicalvaadin.ch02;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("greeting")
public class GreetingView extends VerticalLayout {

  public GreetingView() {
    var button = new Button("Hi");
    button.addClickListener(event ->
        Notification.show("Hello!")
    );

    add(button);
  }

}
