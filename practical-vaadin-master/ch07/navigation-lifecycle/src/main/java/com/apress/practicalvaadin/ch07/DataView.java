package com.apress.practicalvaadin.ch07;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.VaadinSession;

import java.util.Optional;

@Route("data")
public class DataView extends Composite<Component>
    implements BeforeEnterObserver, BeforeLeaveObserver {

  private TextArea textArea;

  @Override
  protected Component initContent() {
    textArea = new TextArea("Data", getData().orElse(""), "type your data here");

    return new VerticalLayout(
        new H1("Data view"),
        new RouterLink("Home", HomeView.class),
        textArea,
        new Button("Save", event -> {
          setData(textArea.getValue());
          Notification.show("Thanks for your data");
        })
    );
  }

  @Override
  public void beforeEnter(BeforeEnterEvent event) {
    if (getData().isEmpty() || getData().get().isEmpty()) {
      event.rerouteTo(NoDataView.class);
    }
  }

  @Override
  public void beforeLeave(BeforeLeaveEvent event) {
    if (!getData().get().equals(textArea.getValue())) {
      BeforeLeaveEvent.ContinueNavigationAction action = event.postpone();
      Dialog dialog = new Dialog();
      dialog.add(
          new Text("Are you sure?"),
          new Button("Yeah", clickEvent -> {
            dialog.close();
            action.proceed();
          })
      );
      dialog.open();
    }
  }

  private Optional<String> getData() {
    String data = (String) VaadinSession.getCurrent().getAttribute("data");
    return Optional.ofNullable(data);
  }

  private void setData(String data) {
    VaadinSession.getCurrent().setAttribute("data", data);
  }
}
