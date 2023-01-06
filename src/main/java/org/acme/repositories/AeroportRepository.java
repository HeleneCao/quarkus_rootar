package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.acme.entities.AeroportEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("AeroportRepository")
public class AeroportRepository implements PanacheRepositoryBase<AeroportEntity, Integer> {
}
