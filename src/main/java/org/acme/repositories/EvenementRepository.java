package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.acme.entities.EvenementsEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("EvenementRepository")
public class EvenementRepository implements PanacheRepositoryBase<EvenementsEntity,Integer> {
}
