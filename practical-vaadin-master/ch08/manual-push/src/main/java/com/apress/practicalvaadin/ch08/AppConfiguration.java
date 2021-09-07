package com.apress.practicalvaadin.ch08;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.shared.communication.PushMode;

@Push(value = PushMode.MANUAL)
public class AppConfiguration implements AppShellConfigurator {

}
