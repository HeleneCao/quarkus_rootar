package org.acme.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "APPARTENIR", schema = "dbo", catalog = "ROOTAR")
@IdClass(AppartenirEntityPK.class)
public class AppartenirEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_THEME")
    private int idTheme;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_REGION")
    private int idRegion;

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppartenirEntity that = (AppartenirEntity) o;
        return idTheme == that.idTheme && idRegion == that.idRegion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTheme, idRegion);
    }
}
