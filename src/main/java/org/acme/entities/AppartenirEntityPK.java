package org.acme.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AppartenirEntityPK implements Serializable {
    @Column(name = "ID_THEME")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTheme;
    @Column(name = "ID_REGION")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRegion;

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppartenirEntityPK that = (AppartenirEntityPK) o;
        return idTheme == that.idTheme && idRegion == that.idRegion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTheme, idRegion);
    }
}
