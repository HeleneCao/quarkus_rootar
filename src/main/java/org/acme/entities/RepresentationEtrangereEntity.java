package org.acme.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "REPRESENTATION_ETRANGERE", schema = "dbo", catalog = "ROOTAR")
public class RepresentationEtrangereEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_REPRESENTATION")
    private int idRepresentation;
    @Basic
    @Column(name = "LIBELLE_REPRESENTATION")
    private String libelleRepresentation;
    @Basic
    @Column(name = "TELEPHONE")
    private String telephone;
    @Basic
    @Column(name = "ADRESSE")
    private String adresse;
    @Basic
    @Column(name = "ID_PAYS")
    private int idPays;
    @Basic
    @Column(name = "ID_VILLE")
    private int idVille;

    public int getIdRepresentation() {
        return idRepresentation;
    }

    public void setIdRepresentation(int idRepresentation) {
        this.idRepresentation = idRepresentation;
    }

    public String getLibelleRepresentation() {
        return libelleRepresentation;
    }

    public void setLibelleRepresentation(String libelleRepresentation) {
        this.libelleRepresentation = libelleRepresentation;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getIdPays() {
        return idPays;
    }

    public void setIdPays(int idPays) {
        this.idPays = idPays;
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
        RepresentationEtrangereEntity that = (RepresentationEtrangereEntity) o;
        return idRepresentation == that.idRepresentation && idPays == that.idPays && idVille == that.idVille && Objects.equals(libelleRepresentation, that.libelleRepresentation) && Objects.equals(telephone, that.telephone) && Objects.equals(adresse, that.adresse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRepresentation, libelleRepresentation, telephone, adresse, idPays, idVille);
    }
}
