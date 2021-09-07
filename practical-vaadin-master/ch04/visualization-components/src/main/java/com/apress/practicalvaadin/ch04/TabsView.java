package com.apress.practicalvaadin.ch04;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;

@Route("tabs")
public class TabsView extends Composite<Component> {

  @Override
  protected Component initContent() {
    VerticalLayout tabsContainer = new VerticalLayout();

    Tab order = new Tab("Order");
    Tab delivery = new Tab("Delivery");
    Tabs tabs = new Tabs(order, delivery);

    // FIXME: The Order tab is now shown at start
    tabs.addSelectedChangeListener(event -> {
      Tab selected = event.getSelectedTab();
      tabsContainer.removeAll();

      if (order.equals(selected)) {
        tabsContainer.add(buildOrderTab());
      } else if (delivery.equals(selected)) {
        tabsContainer.add(buildDeliveryTab());
      }
    });

    return new VerticalLayout(tabs, tabsContainer);
  }

  private Component buildOrderTab() {
    return new Text("Order info");
  }

  private Component buildDeliveryTab() {
    return new Text("Delivery info");
  }

}
