package com.apress.practicalvaadin.ch04;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("checkbox")
public class CheckboxView extends Composite<Component> {

    @Override
    protected Component initContent() {
        Checkbox checkbox = new Checkbox();
        checkbox.setLabelAsHtml("I'm <b>learning</b> Vaadin!");

        checkbox.setValue(true);
        checkbox.setIndeterminate(true);
        Boolean initialValue = checkbox.getValue();
        Notification.show("Initial value: " + initialValue);

        checkbox.addValueChangeListener(event -> {
            Boolean value = event.getValue();
            Notification.show("Value: " + value);
        });

        return new VerticalLayout(checkbox);
    }
}
