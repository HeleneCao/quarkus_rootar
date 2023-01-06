package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.acme.entities.RepresentationEtrangereEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("RepresentationEtrangereRepository")
public class RepresentationEtrangereRepository implements PanacheRepositoryBase<RepresentationEtrangereEntity,Integer> {


}
