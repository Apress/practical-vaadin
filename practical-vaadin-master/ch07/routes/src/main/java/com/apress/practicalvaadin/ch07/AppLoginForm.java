package com.apress.practicalvaadin.ch07;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteConfiguration;

@Route("login")
public class AppLoginForm extends Composite<Component> {

  @Override
  protected Component initContent() {
    LoginI18n i18n = LoginI18n.createDefault();

    LoginOverlay loginOverlay = new LoginOverlay(i18n);
    loginOverlay.setTitle("Chapter 7");
    loginOverlay.setDescription("Navigation and Routing");
    loginOverlay.setOpened(true);

    loginOverlay.addForgotPasswordListener(event ->
        Notification.show("Use admin/admin or user/user"));

    loginOverlay.addLoginListener(event -> {
      if ("user".equals(event.getUsername())
          && "user".equals(event.getPassword())) {
        RouteConfiguration.forSessionScope().setRoute(
            "user", UserView.class, MainLayout.class
        );
        UI.getCurrent().navigate(UserView.class);
        loginOverlay.close();

      } else if ("admin".equals(event.getUsername())
          && "admin".equals(event.getPassword())) {
        RouteConfiguration.forSessionScope().setRoute(
            "admin", AdminView.class, MainLayout.class
        );
        UI.getCurrent().navigate(AdminView.class);
        loginOverlay.close();

      } else {
        loginOverlay.setError(true);
      }
    });

    return new VerticalLayout(loginOverlay);
  }

}
