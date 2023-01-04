package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.acme.entities.CategoriesEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("CategoriesRepository")
public class CategoriesRepository implements PanacheRepositoryBase<CategoriesEntity,Integer> {
}
