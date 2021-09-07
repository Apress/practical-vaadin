package com.apress.practicalvaadin.ch08;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.router.Route;

@Route("manual-push")
public class ManualPushView extends Composite<Component> {

  private VerticalLayout layout;
  private ProgressBar progressBar = new ProgressBar(0, 10);
  private Button button;

  @Override
  protected Component initContent() {
    button = new Button("Run long task", event -> runLongTaks());
    button.setDisableOnClick(true);
    layout = new VerticalLayout(button,
        new Button("Does this work?", event -> addText()),
        progressBar);
    return layout;
  }

  private void runLongTaks() {
    Notification.show("Running the task...");
    progressBar.setValue(0);
    var ui = UI.getCurrent();
    new Thread(() -> {
      try {
        for (int i = 0; i <= 10; i++) {
          Thread.sleep(1000);
          double progress = i;
          ui.access(() -> {
            progressBar.setValue(progress);
            ui.push();
          });
        }

        ui.access(() -> {
          Notification.show("Task completed.");
          button.setEnabled(true);
          ui.push();
        });
      } catch (InterruptedException ignored) {
      }
    }).start();
  }

  private void addText() {
    layout.add(new Paragraph("It works!"));
  }

}
