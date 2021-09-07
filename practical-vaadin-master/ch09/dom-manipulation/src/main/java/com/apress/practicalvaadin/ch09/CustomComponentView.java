package com.apress.practicalvaadin.ch09;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import elemental.json.JsonObject;

@Route("custom-component")
public class CustomComponentView extends Composite<Component> {

  @Override
  protected Component initContent() {
    var button = new PictureButton(
        "https://live.staticflickr.com/65535/51154022090_22fd569976_k.jpg",
        event -> {
          JsonObject data = event.getEventData();
          var x = data.getNumber("event.clientX");
          var y = data.getNumber("event.clientY");
          Notification.show("Clicked at " + x + ", " + y);
        });
    button.setWidth("65%");

    var layout = new VerticalLayout(button);
    layout.setAlignItems(Alignment.CENTER);
    return layout;
  }

}
