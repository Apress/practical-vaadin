package com.apress.practicalvaadin.ch09;

import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.router.Route;

@Route("javascript-integration")
@JsModule("script.js")
@JsModule("https://code.jquery.com/jquery-3.6.0.min.js")
public class JavascriptIntegrationView extends Div {

  public JavascriptIntegrationView() {

    var image = new Image(
        "https://live.staticflickr.com/65535/51154022090_22fd569976_k.jpg",
        "dog");
    image.setMaxWidth("100%");

    UI.getCurrent().getPage()
        .executeJs("return ns.init($0, $1)", image, this);

    Button button = new Button("Toggle visibility", event -> {
      UI.getCurrent().getPage()
          .executeJs("return ns.toggle($0)", image)
          .then(value -> Notification.show(value.asString()));

    });

    add(button, image);
    getElement().getStyle().set("display", "grid");
    getElement().getStyle().set("padding", "1em");
    getElement().getStyle().set("max-width", "700px");
  }

  @ClientCallable
  public void showClickNotification(Integer x, Integer y) {
    var message = String.format("Clicked at %d, %d", x, y);
    Notification.show(message, 3000, Position.BOTTOM_END);
  }

}
