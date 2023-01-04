package org.acme.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "AEROPORT", schema = "dbo", catalog = "ROOTAR")
public class AeroportEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_AEROPORT")
    private int idAeroport;
    @Basic
    @Column(name = "LIBELLE_AEROPORT")
    private String libelleAeroport;
    @Basic
    @Column(name = "ADRESSE")
    private String adresse;
    @Basic
    @Column(name = "TELEPHONE")
    private String telephone;
    @Basic
    @Column(name = "ID_VILLE")
    private int idVille;

    public int getIdAeroport() {
        return idAeroport;
    }

    public void setIdAeroport(int idAeroport) {
        this.idAeroport = idAeroport;
    }

    public String getLibelleAeroport() {
        return libelleAeroport;
    }

    public void setLibelleAeroport(String libelleAeroport) {
        this.libelleAeroport = libelleAeroport;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
        AeroportEntity that = (AeroportEntity) o;
        return idAeroport == that.idAeroport && idVille == that.idVille && Objects.equals(libelleAeroport, that.libelleAeroport) && Objects.equals(adresse, that.adresse) && Objects.equals(telephone, that.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAeroport, libelleAeroport, adresse, telephone, idVille);
    }
}
