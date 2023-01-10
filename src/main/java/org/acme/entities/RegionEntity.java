package org.acme.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
@Data
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


    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "ID_TYPE_CLIMAT")
    private TypeClimatEntity typeClimat;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "ID_PAYS")
    private PaysEntity pays;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "appartenir",
            joinColumns = @JoinColumn(name = "ID_REGION"),
            inverseJoinColumns = @JoinColumn(name = "ID_THEME")
    )
    private List<ThemesEntity> themes;

}
