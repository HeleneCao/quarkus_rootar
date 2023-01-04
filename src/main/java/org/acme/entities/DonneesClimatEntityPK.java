package org.acme.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class DonneesClimatEntityPK implements Serializable {
    @Column(name = "ID_REGION")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRegion;
    @Column(name = "MOIS")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mois;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DonneesClimatEntityPK that = (DonneesClimatEntityPK) o;
        return idRegion == that.idRegion && mois == that.mois;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRegion, mois);
    }
}
