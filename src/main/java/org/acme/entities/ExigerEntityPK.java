package org.acme.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ExigerEntityPK implements Serializable {
    @Column(name = "ID_PAYS")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPays;
    @Column(name = "ID_SANTE")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSante;

    public int getIdPays() {
        return idPays;
    }

    public void setIdPays(int idPays) {
        this.idPays = idPays;
    }

    public int getIdSante() {
        return idSante;
    }

    public void setIdSante(int idSante) {
        this.idSante = idSante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExigerEntityPK that = (ExigerEntityPK) o;
        return idPays == that.idPays && idSante == that.idSante;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPays, idSante);
    }
}
