package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.acme.entities.ContinentEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("ContinentRepository")
public class ContinentRepository implements PanacheRepositoryBase<ContinentEntity, Integer> {
}
