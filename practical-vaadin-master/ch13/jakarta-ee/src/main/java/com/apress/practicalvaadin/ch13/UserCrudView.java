package com.apress.practicalvaadin.ch13;

import javax.inject.Inject;

import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.layout.impl.HorizontalSplitCrudLayout;
import org.vaadin.crudui.layout.impl.VerticalCrudLayout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.Route;

@Route("user-crud")
public class UserCrudView extends Composite<Component> {

  private final UserRepository userRepository;

  @Inject
  public UserCrudView(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  protected Component initContent() {
    var crud = new GridCrud<>(User.class,
        new VerticalCrudLayout());
    crud.setSizeFull();
    crud.getGrid().setHeightByRows(true);
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.setClickRowToUpdate(true);
    crud.setUpdateOperationVisible(false);
    
    crud.getGrid().setColumns("email", "birthDate",
        "favoriteNumber");
    crud.getCrudFormFactory().setVisibleProperties("email",
        "password", "birthDate", "favoriteNumber");
    crud.getCrudFormFactory().setFieldType("password",
        PasswordField.class);
    crud.setFindAllOperation(userRepository::findAll);
    crud.setAddOperation(userRepository::save);
    crud.setUpdateOperation(userRepository::save);
    crud.setDeleteOperation(userRepository::attachAndRemove);

    VerticalLayout layout = new VerticalLayout(crud);
    layout.setSizeFull();
    return layout;
  }

}
