package com.apress.practicalvaadin.ch08;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("with-push")
public class WithPushView extends Composite<Component> {

  private VerticalLayout layout;

  @Override
  protected Component initContent() {
    layout = new VerticalLayout(
        new Button("Run long task", event -> runLongTaks()),
        new Button("Does this work?", event -> addText()));
    return layout;
  }

  private void runLongTaks() {
    Notification.show("Running the task...");
    var ui = UI.getCurrent();
    new Thread(() -> {
      try {
        Thread.sleep(5000);
        ui.access(() -> {
          Notification.show("Task completed.");
        });
      } catch (InterruptedException ignored) {
      }
    }).start();
  }

  private void addText() {
    layout.add(new Paragraph("It works!"));
  }

}
