package org.acme.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "THEMES", schema = "dbo", catalog = "ROOTAR")
public class ThemesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_THEME")
    private int idTheme;
    @Basic
    @Column(name = "LIBELLE_THEME")
    private String libelleTheme;

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
    }

    public String getLibelleTheme() {
        return libelleTheme;
    }

    public void setLibelleTheme(String libelleTheme) {
        this.libelleTheme = libelleTheme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThemesEntity that = (ThemesEntity) o;
        return idTheme == that.idTheme && Objects.equals(libelleTheme, that.libelleTheme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTheme, libelleTheme);
    }
}
