package com.apress.practicalvaadin.ch13;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface UserRepository
    extends EntityRepository<User, Integer> {

}
