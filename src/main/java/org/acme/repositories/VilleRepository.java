package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.acme.entities.VilleEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("VilleRepository")
public class VilleRepository implements PanacheRepositoryBase<VilleEntity, Integer> {
}
