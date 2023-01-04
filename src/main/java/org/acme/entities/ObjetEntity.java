package org.acme.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "OBJET", schema = "dbo", catalog = "ROOTAR")
public class ObjetEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_OBJET")
    private int idObjet;
    @Basic
    @Column(name = "LIBELLE_OBJET")
    private String libelleObjet;
    @Basic
    @Column(name = "ID_CATEGORIES")
    private int idCategories;

    public int getIdObjet() {
        return idObjet;
    }

    public void setIdObjet(int idObjet) {
        this.idObjet = idObjet;
    }

    public String getLibelleObjet() {
        return libelleObjet;
    }

    public void setLibelleObjet(String libelleObjet) {
        this.libelleObjet = libelleObjet;
    }

    public int getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(int idCategories) {
        this.idCategories = idCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjetEntity that = (ObjetEntity) o;
        return idObjet == that.idObjet && idCategories == that.idCategories && Objects.equals(libelleObjet, that.libelleObjet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idObjet, libelleObjet, idCategories);
    }
}
