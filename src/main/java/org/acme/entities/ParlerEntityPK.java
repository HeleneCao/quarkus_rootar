package org.acme.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ParlerEntityPK implements Serializable {
    @Column(name = "ID_PAYS")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPays;
    @Column(name = "ID_LANGUES")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLangues;

    public int getIdPays() {
        return idPays;
    }

    public void setIdPays(int idPays) {
        this.idPays = idPays;
    }

    public int getIdLangues() {
        return idLangues;
    }

    public void setIdLangues(int idLangues) {
        this.idLangues = idLangues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParlerEntityPK that = (ParlerEntityPK) o;
        return idPays == that.idPays && idLangues == that.idLangues;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPays, idLangues);
    }
}
