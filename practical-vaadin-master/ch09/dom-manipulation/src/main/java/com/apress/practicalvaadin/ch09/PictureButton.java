package com.apress.practicalvaadin.ch09;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.dom.DomEvent;
import com.vaadin.flow.dom.DomEventListener;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.function.SerializableConsumer;

@Tag("img")
public class PictureButton extends Component implements HasSize {

  public PictureButton(String imageUrl,
      SerializableConsumer<DomEvent> clickListener) {

    getElement().setAttribute("src", imageUrl);

    Style style = getElement().getStyle();
    style.set("border", "1em solid #333");
    style.set("box-sizing", "border-box");

    String shadow = "1em 1em 1em #777";
    style.set("box-shadow", shadow);

    getElement().addEventListener("click", clickListener::accept)
        .addEventData("event.clientX")
        .addEventData("event.clientY");

    getElement().addEventListener("mousedown", event -> {
      style.set("transform", "scale(0.93)");
      style.remove("box-shadow");
    });

    DomEventListener listener = event -> {
      style.set("transform", "scale(1)");
      style.set("box-shadow", shadow);
    };
    getElement().addEventListener("mouseup", listener);
    getElement().addEventListener("pointerleave", listener);
  }

}
