package com.apress.practicalvaadin.ch13;

import javax.inject.Inject;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("user-count")
public class UserCountView extends Composite<Component> {

  private final UserRepository userRepository;

  @Inject
  public UserCountView(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  protected Component initContent() {
    long count = userRepository.count();
    return new VerticalLayout(new H1("How many users?"),
        new Text(count + " users found."));
  }

}
