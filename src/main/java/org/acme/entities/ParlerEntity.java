package org.acme.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PARLER", schema = "dbo", catalog = "ROOTAR")
@IdClass(ParlerEntityPK.class)
public class ParlerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PAYS")
    private int idPays;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_LANGUES")
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
        ParlerEntity that = (ParlerEntity) o;
        return idPays == that.idPays && idLangues == that.idLangues;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPays, idLangues);
    }
}
