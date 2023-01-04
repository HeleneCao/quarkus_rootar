package org.acme.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EmporterEntityPK implements Serializable {
    @Column(name = "ID_OBJET")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idObjet;
    @Column(name = "ID_PAYS")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPays;

    public int getIdObjet() {
        return idObjet;
    }

    public void setIdObjet(int idObjet) {
        this.idObjet = idObjet;
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
        EmporterEntityPK that = (EmporterEntityPK) o;
        return idObjet == that.idObjet && idPays == that.idPays;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idObjet, idPays);
    }
}
