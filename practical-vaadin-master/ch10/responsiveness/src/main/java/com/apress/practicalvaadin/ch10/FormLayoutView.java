package com.apress.practicalvaadin.ch10;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.router.Route;

@Route("form-layout")
public class FormLayoutView extends Composite<Component> {

  @Override
  protected Component initContent() {
    Button increaseRadiation = new Button("Increase radiation",
        VaadinIcon.ARROW_UP.create());
    increaseRadiation
        .addThemeVariants(ButtonVariant.LUMO_ERROR);
    Button shutDownCooling = new Button("Shutdown cooling",
        VaadinIcon.POWER_OFF.create());
    shutDownCooling
        .addThemeVariants(ButtonVariant.LUMO_SUCCESS);
    NumberField temperature = new NumberField("Temperature");
    temperature
        .addThemeVariants(TextFieldVariant.LUMO_ALIGN_CENTER);
    NumberField pressure = new NumberField("Pressure");
    pressure
        .addThemeVariants(TextFieldVariant.LUMO_ALIGN_CENTER);
    NumberField hydrogen = new NumberField("Hydrogen");
    hydrogen
        .addThemeVariants(TextFieldVariant.LUMO_ALIGN_CENTER);
    NumberField oxygen = new NumberField("Oxygen");
    oxygen.addThemeVariants(TextFieldVariant.LUMO_ALIGN_CENTER);
    DatePicker shutdownDate = new DatePicker("Shutdown date");
    Button update = new Button("Update reactor",
        VaadinIcon.WARNING.create());
    update.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

    FormLayout form = new FormLayout(increaseRadiation,
        shutDownCooling, temperature, pressure, hydrogen,
        oxygen, shutdownDate);
    
    form.setResponsiveSteps(
        new ResponsiveStep("1px", 1),
        new ResponsiveStep("600px", 2),
        new ResponsiveStep("800px", 3)
        );

    VerticalLayout layout = new VerticalLayout(
        new H1("Nuclear Reactor"), form, update);
    layout.setAlignItems(Alignment.CENTER);
    layout.setAlignSelf(Alignment.END, update);
    return layout;
  }

}
