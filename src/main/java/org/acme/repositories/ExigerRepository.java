package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.acme.entities.ExigerEntity;
import org.acme.entities.ExigerEntityPK;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("ExigerRepository")
public class ExigerRepository implements PanacheRepositoryBase<ExigerEntity, ExigerEntityPK> {

}
