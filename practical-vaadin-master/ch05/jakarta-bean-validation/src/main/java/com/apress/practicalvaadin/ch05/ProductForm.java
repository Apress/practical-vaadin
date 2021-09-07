package com.apress.practicalvaadin.ch05;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.*;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.function.SerializableRunnable;

import java.util.Set;

public class ProductForm extends Composite<Component> {

  private final SerializableRunnable saveListener;

  private TextField name = new TextField("Name");
  private TextField code = new TextField("Code");
  private ComboBox<Manufacturer> manufacturer = new ComboBox<>();
  private Checkbox available = new Checkbox("Available");
  private TextField phoneNumber = new TextField("Manufacturer phone number");
  private TextField email = new TextField("Manufacturer email");

  private BeanValidationBinder<Product> binder = new BeanValidationBinder<>(Product.class);

  public ProductForm(Product product, Set<Manufacturer> manufacturers,
                     SerializableRunnable saveListener) {
    this.saveListener = saveListener;

    manufacturer.setItems(manufacturers);
    manufacturer.setItemLabelGenerator(Manufacturer::getName);

    binder.forField(name).bind("name");

    binder.forField(code)
        .withConverter(new StringToCodeConverter())
        .bind(Product::getCode, Product::setCode);

    binder.forField(manufacturer).bind("manufacturer");
    binder.forField(available).bind("available");

    if (product.getName() == null) {
      phoneNumber.setVisible(false);
      email.setVisible(false);
    } else {
      manufacturer.setEnabled(false);
      binder.forField(phoneNumber).bind("manufacturer.phoneNumber");
      binder.forField(email).bind("manufacturer.email");
    }

    new Validator<>() {
      @Override
      public ValidationResult apply(Object o, ValueContext valueContext) {
        return null;
      }
    };

    binder.setBean(product);
  }

  @Override
  protected Component initContent() {
    return new VerticalLayout(
        new H1("Product"),
        name,
        code,
        available,
        manufacturer,
        phoneNumber,
        email,
        new Button("Save", VaadinIcon.CHECK.create(),
            event -> {
              binder.validate();
              if (binder.isValid()) {
                saveListener.run();
              } else {
                Notification.show("Please fix the errors");
              }
            })
    );
  }

}
