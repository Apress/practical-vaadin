package com.apress.practicalvaadin.ch07;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.HasDynamicTitle;
import com.vaadin.flow.router.Route;

import java.time.LocalDateTime;

@Route("dynamic-page-title")
public class DynamicPageTitleView extends Composite<Component>
implements HasDynamicTitle {

  @Override
  protected Component initContent() {
    return new H1("Hello again, and bye for now!");
  }

  @Override
  public String getPageTitle() {
    return "Title at " + LocalDateTime.now();
  }

}
