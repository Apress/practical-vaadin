package com.apress.practicalvaadin.ch04;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("notification")
public class NotificationView extends Composite<Component> {

  private boolean firstTime = true;

  @Override
  protected Component initContent() {
    return new VerticalLayout(
        new Button("Notification", event -> {
          Notification notification = new Notification();
          notification.add(new VerticalLayout(new Text("Here it is!")));
          notification.setPosition(Notification.Position.MIDDLE);

          if (firstTime) {
            notification.setDuration(0);
            notification.add(new Button("Close", e ->
                notification.close()));
          } else {
            notification.setDuration(2000);
          }

          firstTime = false;
          notification.open();
        }),
        new Button("Dialog", event -> {
          Dialog dialog = new Dialog(
              new VerticalLayout(
                  new H2("Title"),
                  new Text("Text! (hit ESC to close)"),
                  new Button("Button!!!")
              )
          );

          dialog.open();
          dialog.setModal(true);
          dialog.setCloseOnOutsideClick(false);
          dialog.setCloseOnEsc(true);
          dialog.setDraggable(true);
        })
    );
  }

}
