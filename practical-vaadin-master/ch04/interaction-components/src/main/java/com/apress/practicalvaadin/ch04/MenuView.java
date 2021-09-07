package com.apress.practicalvaadin.ch04;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.contextmenu.ContextMenu;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("menu")
public class MenuView extends Composite<Component> {

    @Override
    protected Component initContent() {
        MenuBar menuBar = new MenuBar();

        MenuItem file = menuBar.addItem("File");
        file.getSubMenu().addItem("New").setCheckable(true);
        file.getSubMenu().addItem("Open");

        MenuItem edit = menuBar.addItem("Edit");
        edit.getSubMenu().addItem("Copy", event ->
                Notification.show("Copy selected"));
        MenuItem paste = edit.getSubMenu().addItem("Paste");
        paste.addClickListener(event ->
                Notification.show("Paste selected"));
        paste.setEnabled(false);

        HorizontalLayout target = new HorizontalLayout(
                new Text("Right click here")
        );
        ContextMenu contextMenu = new ContextMenu(target);
        contextMenu.addItem("Copy");
        contextMenu.addItem("Paste");

        return new VerticalLayout(menuBar, target);
    }

}
