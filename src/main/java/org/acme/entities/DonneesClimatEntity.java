package org.acme.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
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

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public String getLibelleMois() {
        return libelleMois;
    }

    public void setLibelleMois(String libelleMois) {
        this.libelleMois = libelleMois;
    }

    public double getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public double getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public Double getTemperatureMoy() {
        return temperatureMoy;
    }

    public void setTemperatureMoy(Double temperatureMoy) {
        this.temperatureMoy = temperatureMoy;
    }

    public int getTauxHumidite() {
        return tauxHumidite;
    }

    public void setTauxHumidite(int tauxHumidite) {
        this.tauxHumidite = tauxHumidite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DonneesClimatEntity that = (DonneesClimatEntity) o;
        return idRegion == that.idRegion && mois == that.mois && Double.compare(that.temperatureMin, temperatureMin) == 0 && Double.compare(that.temperatureMax, temperatureMax) == 0 && tauxHumidite == that.tauxHumidite && Objects.equals(libelleMois, that.libelleMois) && Objects.equals(temperatureMoy, that.temperatureMoy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRegion, mois, libelleMois, temperatureMin, temperatureMax, temperatureMoy, tauxHumidite);
    }
}
