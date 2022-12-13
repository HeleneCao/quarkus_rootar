package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.acme.entities.ContinentEntity;
import org.acme.entities.PrioriteEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("PrioriteRepository")
public class PrioriteRepository implements PanacheRepositoryBase<PrioriteEntity, Integer> {
}
