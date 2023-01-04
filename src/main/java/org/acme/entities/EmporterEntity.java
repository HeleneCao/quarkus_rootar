package org.acme.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "emporter", schema = "dbo", catalog = "ROOTAR")
@IdClass(EmporterEntityPK.class)
public class EmporterEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_OBJET")
    private int idObjet;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PAYS")
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
        EmporterEntity that = (EmporterEntity) o;
        return idObjet == that.idObjet && idPays == that.idPays;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idObjet, idPays);
    }
}
