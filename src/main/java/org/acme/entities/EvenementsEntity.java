package org.acme.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "EVENEMENTS", schema = "dbo", catalog = "ROOTAR")
public class EvenementsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_EVENEMENTS")
    private int idEvenements;
    @Basic
    @Column(name = "LIBELLE_EVENEMENTS")
    private String libelleEvenements;
    @Basic
    @Column(name = "DATE_DEBUT_EVENEMENTS")
    private String dateDebutEvenements;
    @Basic
    @Column(name = "DATE_FIN_EVENEMENTS")
    private String dateFinEvenements;
    @Basic
    @Column(name = "DESCRIPTION_EVENEMENT")
    private String descriptionEvenement;
    @Basic
    @Column(name = "ID_VILLE")
    private int idVille;

    public int getIdEvenements() {
        return idEvenements;
    }

    public void setIdEvenements(int idEvenements) {
        this.idEvenements = idEvenements;
    }

    public String getLibelleEvenements() {
        return libelleEvenements;
    }

    public void setLibelleEvenements(String libelleEvenements) {
        this.libelleEvenements = libelleEvenements;
    }

    public String getDateDebutEvenements() {
        return dateDebutEvenements;
    }

    public void setDateDebutEvenements(String dateDebutEvenements) {
        this.dateDebutEvenements = dateDebutEvenements;
    }

    public String getDateFinEvenements() {
        return dateFinEvenements;
    }

    public void setDateFinEvenements(String dateFinEvenements) {
        this.dateFinEvenements = dateFinEvenements;
    }

    public String getDescriptionEvenement() {
        return descriptionEvenement;
    }

    public void setDescriptionEvenement(String descriptionEvenement) {
        this.descriptionEvenement = descriptionEvenement;
    }

    public int getIdVille() {
        return idVille;
    }

    public void setIdVille(int idVille) {
        this.idVille = idVille;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EvenementsEntity that = (EvenementsEntity) o;
        return idEvenements == that.idEvenements && idVille == that.idVille && Objects.equals(libelleEvenements, that.libelleEvenements) && Objects.equals(dateDebutEvenements, that.dateDebutEvenements) && Objects.equals(dateFinEvenements, that.dateFinEvenements) && Objects.equals(descriptionEvenement, that.descriptionEvenement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEvenements, libelleEvenements, dateDebutEvenements, dateFinEvenements, descriptionEvenement, idVille);
    }
}
