package com.apress.practicalvaadin.ch10;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.theme.material.Material;

@Theme(themeClass = Material.class)
//@Theme(themeClass = Lumo.class, variant = Lumo.DARK)
public class AppConfiguration implements AppShellConfigurator {

}
