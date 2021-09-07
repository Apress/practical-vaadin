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
import com.vaadin.flow.function.SerializableRunnable;

import java.util.Set;

public class ProductForm extends Composite<Component> {

  private final SerializableRunnable saveListener;

  private TextField name = new TextField("Name");
  private ComboBox<Manufacturer> comboBox = new ComboBox<>();
  private Checkbox unavailable = new Checkbox("Unavailable");

  public ProductForm(Product product, Set<Manufacturer> manufacturers,
                     SerializableRunnable saveListener) {
    this.saveListener = saveListener;

    comboBox.setItems(manufacturers);
    comboBox.setItemLabelGenerator(Manufacturer::getName);

    Binder<Product> binder = new Binder<>(Product.class);
    binder.bind(name, Product::getName, Product::setName);
    binder.bind(comboBox, "manufacturer");
    binder.bind(unavailable,
        prod -> !prod.isAvailable(),
        (prod, booleanValue) -> prod.setAvailable(!booleanValue));
    binder.setBean(product);
  }

  @Override
  protected Component initContent() {
    return new VerticalLayout(
        new H1("Product"),
        name,
        comboBox,
        unavailable,
        new Button("Save", VaadinIcon.CHECK.create(),
            event -> saveListener.run())
    );
  }

}
