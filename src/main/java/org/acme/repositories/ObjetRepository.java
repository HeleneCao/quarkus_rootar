package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.acme.entities.CategoriesEntity;
import org.acme.entities.ObjetEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("ObjetRepository")
public class ObjetRepository implements PanacheRepositoryBase<ObjetEntity,Integer> {
}
