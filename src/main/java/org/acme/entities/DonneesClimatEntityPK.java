package org.acme.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
@Data
public class DonneesClimatEntityPK implements Serializable {
    @Column(name = "ID_REGION")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRegion;
    @Column(name = "MOIS")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mois;


}
