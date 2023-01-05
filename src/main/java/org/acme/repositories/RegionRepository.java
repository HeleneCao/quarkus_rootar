package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.acme.entities.CategoriesEntity;
import org.acme.entities.RegionEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("RegionRepository")
public class RegionRepository implements PanacheRepositoryBase<RegionEntity,Integer> {
}
