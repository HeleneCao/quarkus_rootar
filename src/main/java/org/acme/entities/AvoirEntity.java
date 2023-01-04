package org.acme.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "AVOIR", schema = "dbo", catalog = "ROOTAR")
@IdClass(AvoirEntityPK.class)
public class AvoirEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_THEME")
    private int idTheme;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PAYS")
    private int idPays;

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
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
        AvoirEntity that = (AvoirEntity) o;
        return idTheme == that.idTheme && idPays == that.idPays;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTheme, idPays);
    }
}
