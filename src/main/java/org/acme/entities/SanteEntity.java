package org.acme.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SANTE", schema = "dbo", catalog = "ROOTAR")
public class SanteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_SANTE")
    private int idSante;
    @Basic
    @Column(name = "LIBELLE_SANTE")
    private String libelleSante;
    @Basic
    @Column(name = "ID_PRIORITE")
    private int idPriorite;

    public int getIdSante() {
        return idSante;
    }

    public void setIdSante(int idSante) {
        this.idSante = idSante;
    }

    public String getLibelleSante() {
        return libelleSante;
    }

    public void setLibelleSante(String libelleSante) {
        this.libelleSante = libelleSante;
    }

    public int getIdPriorite() {
        return idPriorite;
    }

    public void setIdPriorite(int idPriorite) {
        this.idPriorite = idPriorite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SanteEntity that = (SanteEntity) o;
        return idSante == that.idSante && idPriorite == that.idPriorite && Objects.equals(libelleSante, that.libelleSante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSante, libelleSante, idPriorite);
    }
}
