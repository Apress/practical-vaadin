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
import com.vaadin.flow.function.SerializableRunnable;

import java.util.Set;

public class ProductForm extends Composite<Component> {

  private final Product product;
  private final SerializableRunnable saveListener;

  private TextField name = new TextField("Name");
  private ComboBox<Manufacturer> manufacturer = new ComboBox<>();
  private Checkbox available = new Checkbox("Available");

  public ProductForm(Product product, Set<Manufacturer> manufacturers,
                     SerializableRunnable saveListener) {
    this.product = product;
    this.saveListener = saveListener;

    manufacturer.setItems(manufacturers);
    manufacturer.setItemLabelGenerator(Manufacturer::getName);

    if (product.getName() != null) {
      name.setValue(product.getName());
      manufacturer.setValue(product.getManufacturer());
      available.setValue(product.isAvailable());
    }
  }

  @Override
  protected Component initContent() {
    return new VerticalLayout(
        new H1("Product"),
        name,
        manufacturer,
        available,
        new Button("Save", VaadinIcon.CHECK.create(),
            event -> saveClicked())
    );
  }

  private void saveClicked() {
    product.setName(name.getValue());
    product.setManufacturer(manufacturer.getValue());
    product.setAvailable(available.getValue());
    saveListener.run();
  }

}
