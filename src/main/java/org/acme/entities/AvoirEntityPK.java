package org.acme.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AvoirEntityPK implements Serializable {
    @Column(name = "ID_THEME")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTheme;
    @Column(name = "ID_PAYS")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPays;

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
    }

    public int getIdPays() {
        return idPays;
    }

    public void setIdPays(int idPays) {
        this.idPays = idPays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvoirEntityPK that = (AvoirEntityPK) o;
        return idTheme == that.idTheme && idPays == that.idPays;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTheme, idPays);
    }
}
