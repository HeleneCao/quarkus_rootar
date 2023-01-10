package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.acme.entities.ParlerEntity;
import org.acme.entities.ParlerEntityPK;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("Parler")
public class ParlerRepository implements PanacheRepositoryBase <ParlerEntity, ParlerEntityPK> {
}
