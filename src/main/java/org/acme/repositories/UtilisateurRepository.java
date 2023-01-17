package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.acme.entities.UtilisateurEntity;
import org.acme.entities.VilleEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("UtilisateurRepository")
public class UtilisateurRepository implements PanacheRepositoryBase<UtilisateurEntity, String> {
}
