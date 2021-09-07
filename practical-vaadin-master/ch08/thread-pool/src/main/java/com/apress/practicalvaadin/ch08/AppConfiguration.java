package com.apress.practicalvaadin.ch08;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.shared.ui.Transport;

@Push(transport = Transport.LONG_POLLING)
@WebListener
public class AppConfiguration
    implements AppShellConfigurator, ServletContextListener {

  private static ScheduledExecutorService executorService;

  public static ExecutorService getExecutorService() {
    return executorService;
  }

  @Override
  public void contextInitialized(ServletContextEvent event) {
    executorService = Executors.newScheduledThreadPool(3);
  }

  @Override
  public void contextDestroyed(ServletContextEvent event) {
    executorService.shutdown();
  }

}
