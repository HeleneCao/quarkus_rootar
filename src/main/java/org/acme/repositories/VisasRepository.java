package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.acme.entities.PrioriteEntity;
import org.acme.entities.VisasEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("VisasRepository")
public class VisasRepository implements PanacheRepositoryBase<VisasEntity, Integer> {
}
