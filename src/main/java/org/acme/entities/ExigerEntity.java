package org.acme.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "EXIGER", schema = "dbo", catalog = "ROOTAR")
@IdClass(ExigerEntityPK.class)
public class ExigerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PAYS")
    private int idPays;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_SANTE")
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
        ExigerEntity that = (ExigerEntity) o;
        return idPays == that.idPays && idSante == that.idSante;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPays, idSante);
    }
}
