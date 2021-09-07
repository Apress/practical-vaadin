package com.apress.practicalvaadin.ch13;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class EntityManagerProducer {

  @PersistenceUnit(unitName = "jakarta-ee-example-pu")
  private EntityManagerFactory emf;

  @Produces
  public EntityManager create() {
    return emf.createEntityManager();
  }

  public void close(@Disposes EntityManager em) {
    if (em.isOpen()) {
      em.close();
    }
  }

}
