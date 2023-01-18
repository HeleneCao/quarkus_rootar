package org.acme.repositories;



import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.acme.entities.MonnaieEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("MonnaieRepository")
public class MonnaieRepository implements PanacheRepositoryBase<MonnaieEntity, Integer> {
}
