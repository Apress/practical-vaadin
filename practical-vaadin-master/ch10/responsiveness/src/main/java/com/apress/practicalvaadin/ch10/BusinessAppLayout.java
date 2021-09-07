package com.apress.practicalvaadin.ch10;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;

public class BusinessAppLayout extends AppLayout {

  public BusinessAppLayout() {
    Image logo = new Image("https://i.imgur.com/GPpnszs.png",
        "Vaadin Logo");
    logo.setHeight("44px");
    addToNavbar(new DrawerToggle(), logo);

    Tabs tabs = new Tabs(new Tab("Home"), new Tab("CRM"),
        new Tab("Financial"), new Tab("Marketing"),
        new Tab("Sales"), new Tab("Inventory"),
        new Tab("Manufacturing"), new Tab("Supply chain"),
        new Tab("HR"));
    tabs.setOrientation(Tabs.Orientation.VERTICAL);
    addToDrawer(tabs);
  }

}
