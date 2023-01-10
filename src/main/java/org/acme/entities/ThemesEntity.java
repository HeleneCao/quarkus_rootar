package org.acme.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "THEMES", schema = "dbo", catalog = "ROOTAR")
public class ThemesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_THEME")
    private int idTheme;
    @Basic
    @Column(name = "LIBELLE_THEME")
    private String libelleTheme;

    @ManyToMany(mappedBy = "themes")
    private List<PaysEntity> pays;
}
