package com.apress.practicalvaadin.ch12;

import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.layout.impl.HorizontalSplitCrudLayout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.Route;

@Route("user-crud")
public class UserCrudView extends Composite<Component> {

  private final UserRepository userRepository;

  public UserCrudView(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  protected Component initContent() {
    var crud = new GridCrud<>(User.class,
        new HorizontalSplitCrudLayout());
    crud.getGrid().setColumns("email", "birthDate",
        "favoriteNumber");
    crud.getCrudFormFactory().setVisibleProperties("email",
        "password", "birthDate", "favoriteNumber");
    crud.getCrudFormFactory().setFieldType("password",
        PasswordField.class);
    crud.setFindAllOperation(userRepository::findAll);
    crud.setAddOperation(userRepository::save);
    crud.setUpdateOperation(userRepository::save);
    crud.setDeleteOperation(userRepository::delete);

    return new VerticalLayout(crud);
  }

}
