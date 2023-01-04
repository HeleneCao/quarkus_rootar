package org.acme.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "REGION", schema = "dbo", catalog = "ROOTAR")
public class RegionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_REGION")
    private int idRegion;
    @Basic
    @Column(name = "NOM_REGION")
    private String nomRegion;
    @Basic
    @Column(name = "ID_PAYS")
    private int idPays;
    @Basic
    @Column(name = "ID_TYPE_CLIMAT")
    private int idTypeClimat;

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }

    public int getIdPays() {
        return idPays;
    }

    public void setIdPays(int idPays) {
        this.idPays = idPays;
    }

    public int getIdTypeClimat() {
        return idTypeClimat;
    }

    public void setIdTypeClimat(int idTypeClimat) {
        this.idTypeClimat = idTypeClimat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegionEntity that = (RegionEntity) o;
        return idRegion == that.idRegion && idPays == that.idPays && idTypeClimat == that.idTypeClimat && Objects.equals(nomRegion, that.nomRegion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRegion, nomRegion, idPays, idTypeClimat);
    }
}
