package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.acme.entities.SanteEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("SanteRepository")
public class SanteRepository implements PanacheRepositoryBase<SanteEntity,Integer> {
}
