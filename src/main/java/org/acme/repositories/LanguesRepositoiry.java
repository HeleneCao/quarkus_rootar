package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.acme.entities.LanguesEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("LanguesRepository")
public class LanguesRepositoiry implements PanacheRepositoryBase<LanguesEntity, Integer> {
}
