package com.apress.practicalvaadin.ch05;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.PropertyId;
import com.vaadin.flow.function.SerializableRunnable;

import java.util.Set;

public class AutoBindingProductForm extends Composite<Component> {

  private final SerializableRunnable saveListener;

  @PropertyId("name")
  private TextField nameTextField = new TextField("Name");

  @PropertyId("manufacturer")
  private ComboBox<Manufacturer> manufacturerComboBox = new ComboBox<>();

  @PropertyId("available")
  private Checkbox availableCheckbox = new Checkbox("Available");

  public AutoBindingProductForm(Product product, Set<Manufacturer> manufacturers,
                                SerializableRunnable saveListener) {
    this.saveListener = saveListener;

    manufacturerComboBox.setItems(manufacturers);
    manufacturerComboBox.setItemLabelGenerator(Manufacturer::getName);

    Binder<Product> binder = new Binder<>(Product.class);
    binder.bindInstanceFields(this);
    binder.setBean(product);
  }

  @Override
  protected Component initContent() {
    return new VerticalLayout(
        new H1("Product"),
        nameTextField,
        manufacturerComboBox,
        availableCheckbox,
        new Button("Save", VaadinIcon.CHECK.create(),
            event -> saveListener.run())
    );
  }

}
