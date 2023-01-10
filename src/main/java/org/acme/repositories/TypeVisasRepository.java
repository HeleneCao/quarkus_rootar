package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.acme.entities.TypeVisaEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("TypeVisasRepository")
public class TypeVisasRepository implements PanacheRepositoryBase <TypeVisaEntity, Integer> {
}
