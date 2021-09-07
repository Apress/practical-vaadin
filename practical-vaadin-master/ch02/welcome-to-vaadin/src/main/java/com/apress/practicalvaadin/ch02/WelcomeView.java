package com.apress.practicalvaadin.ch02;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class WelcomeView extends VerticalLayout {

  public WelcomeView() {
    var logo = new Image("https://vaadin.com/images/trademark/PNG/VaadinLogomark_RGB_500x500.png",
        "Vaadin logo");
    logo.setWidth(10, Unit.EM);

    var layout = new VerticalLayout(
        new H1("Welcome to Vaadin!"),
        new Paragraph("Congratulations! Your development environment is up and running!"),
        logo,
        new Paragraph("""
            Did you know that Vaadin means reindeer in Finnish? If you look at the Vaadin logo, you'll notice it
            resembles a reindeer. It also represents Java and HTML. Pretty cool, uh?
            """),
        new Paragraph("""
            Anyway, continue your journey in Chapter 2 to learn how to debug your applications and the fundamentals
            of Vaadin. Have fun while learning!
            """),
        new Button("Thank you", event ->
            Notification.show("You are welcome!", 1200, Notification.Position.MIDDLE))
    );
    layout.setMaxWidth(38, Unit.EM);
    layout.setAlignItems(Alignment.CENTER);

    add(layout);
    setAlignItems(Alignment.CENTER);
  }

}
