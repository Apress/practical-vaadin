package com.apress.practicalvaadin.ch04;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.Route;

@Route("password-field")
public class PasswordFieldView extends Composite<Component> {

    @Override
    public Component getContent() {
        PasswordField passwordField = new PasswordField();
        passwordField.setLabel("Password");
        passwordField.setRevealButtonVisible(true);

        passwordField.addValueChangeListener(event -> {
            String password = event.getValue();
            System.out.println("Password: " + password);
        });

        return new VerticalLayout(passwordField);
    }
}
