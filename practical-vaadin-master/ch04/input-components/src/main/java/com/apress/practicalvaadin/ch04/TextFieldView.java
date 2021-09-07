package com.apress.practicalvaadin.ch04;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route("text-field")
public class TextFieldView extends Composite<Component> {

    @Override
    protected Component initContent() {
        TextField textField = new TextField();
        textField.setLabel("Name");
        textField.setPlaceholder("enter your full name");

        textField.setAutoselect(true);
        textField.setAutofocus(true);
        textField.setClearButtonVisible(true);
        textField.setValue("John Doe");

        textField.setRequired(true);
        textField.setMinLength(2);
        textField.setMaxLength(10);
        textField.setPattern("^[a-zA-Z\\s]+");
        textField.setErrorMessage("Letters only. Min 2 chars");

        textField.addValueChangeListener(event -> {
            if (textField.isInvalid()) {
                Notification.show("Invalid name");
            }
        });

        textField.setValueChangeMode(ValueChangeMode.EAGER);

        return new VerticalLayout(textField);
    }

}
