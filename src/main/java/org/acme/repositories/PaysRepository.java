package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.acme.entities.PaysEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("PaysRepository")
public class PaysRepository implements PanacheRepositoryBase<PaysEntity, Integer> {
}
