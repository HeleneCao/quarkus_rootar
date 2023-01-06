package org.acme.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "DONNEES_CLIMAT", schema = "dbo", catalog = "ROOTAR")
@IdClass(DonneesClimatEntityPK.class)
public class DonneesClimatEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_REGION")
    private int idRegion;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MOIS")
    private int mois;
    @Basic
    @Column(name = "LIBELLE_MOIS")
    private String libelleMois;
    @Basic
    @Column(name = "TEMPERATURE_MIN")
    private double temperatureMin;
    @Basic
    @Column(name = "TEMPERATURE_MAX")
    private double temperatureMax;
    @Basic
    @Column(name = "TEMPERATURE_MOY")
    private Double temperatureMoy;
    @Basic
    @Column(name = "TAUX_HUMIDITE")
    private int tauxHumidite;

}
