package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.acme.entities.TypeClimatEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("TypeClimatRepository")
public class TypeClimatRepository implements PanacheRepositoryBase<TypeClimatEntity,Integer> {
}
