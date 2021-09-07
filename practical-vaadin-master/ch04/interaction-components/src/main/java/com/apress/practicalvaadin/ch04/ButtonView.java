package com.apress.practicalvaadin.ch04;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.time.LocalTime;

@Route("button")
public class ButtonView extends Composite<Component> {

    @Override
    protected Component initContent() {
        Button button = new Button("Time in the server", event -> {
            Notification.show("Sure: " + LocalTime.now());
        });
        button.setDisableOnClick(true);

        return new VerticalLayout(button);
    }

}
