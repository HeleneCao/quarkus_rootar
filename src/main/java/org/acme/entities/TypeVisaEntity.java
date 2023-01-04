package org.acme.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TYPE_VISA", schema = "dbo", catalog = "ROOTAR")
public class TypeVisaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_TYPE_VISA")
    private int idTypeVisa;
    @Basic
    @Column(name = "LIBELLE_TYPE_VISA")
    private String libelleTypeVisa;

    public int getIdTypeVisa() {
        return idTypeVisa;
    }

    public void setIdTypeVisa(int idTypeVisa) {
        this.idTypeVisa = idTypeVisa;
    }

    public String getLibelleTypeVisa() {
        return libelleTypeVisa;
    }

    public void setLibelleTypeVisa(String libelleTypeVisa) {
        this.libelleTypeVisa = libelleTypeVisa;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        TypeVisaEntity that = (TypeVisaEntity) object;
        return idTypeVisa == that.idTypeVisa && Objects.equals(libelleTypeVisa, that.libelleTypeVisa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTypeVisa, libelleTypeVisa);
    }
}
