package com.apress.practicalvaadin.ch04;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.InputStreamFactory;
import com.vaadin.flow.server.StreamResource;

import java.io.InputStream;

@Route("image")
public class ImageView extends Composite<Component> {

  @Override
  protected Component initContent() {
    Image photo = new Image(
        "https://live.staticflickr.com/65535/50969482201_be1163c6f1_b.jpg",
        "Funny dog"
    );
    photo.setWidth("100%");

    StreamResource source = new StreamResource("logo", () ->
        getClass().getClassLoader().getResourceAsStream("vaadin-logo.png")
    );

    Image logo = new Image(source, "Logo");
    logo.setWidthFull();

    VerticalLayout layout = new VerticalLayout(
        new H2("Vaadin is fun!"),
        logo,
        photo
    );
    layout.setAlignItems(FlexComponent.Alignment.CENTER);
    return layout;
  }

}
