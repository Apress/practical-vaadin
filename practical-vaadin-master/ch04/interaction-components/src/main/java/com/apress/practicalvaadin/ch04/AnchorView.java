package com.apress.practicalvaadin.ch04;

import com.helger.commons.io.stream.StringInputStream;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;

import java.nio.charset.Charset;
import java.time.LocalTime;

@Route("anchor")
public class AnchorView extends Composite<Component> {

    @Override
    protected Component initContent() {
        Anchor blogLink = new Anchor("https://www.programmingbrain.com",
                "Visit my technical blog");

        Anchor vaadinLink = new Anchor("https://vaadin.com",
                new Button("Visit vaadin.com"));

        Anchor textLink = new Anchor(new StreamResource(
                "text.txt",
                () -> {
                    String content = "Time: " + LocalTime.now();
                    return new StringInputStream(
                            content, Charset.defaultCharset());
                }
        ), "Server-generated text");

        return new VerticalLayout(blogLink, vaadinLink, textLink);
    }
}
