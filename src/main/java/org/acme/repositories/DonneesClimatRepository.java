package org.acme.repositories;


import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.acme.entities.DonneesClimatEntity;
import org.acme.entities.DonneesClimatEntityPK;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("DonneesClimat")
public class DonneesClimatRepository implements PanacheRepositoryBase<DonneesClimatEntity, DonneesClimatEntityPK> {
}
