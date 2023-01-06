package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.acme.entities.ThemesEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("ThemesRepository")
public class ThemesRepository implements PanacheRepositoryBase<ThemesEntity,Integer> {
}
