package org.acme.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Data

@Table(name = "PAYS", schema = "dbo", catalog = "ROOTAR")
public class PaysEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PAYS")
    private int idPays;
    @Basic
    @Column(name = "CODE_PAYS")
    private String codePays;
    @Basic
    @Column(name = "NOM_PAYS_FR")
    private String nomPaysFr;
    @Basic
    @Column(name = "NOM_PAYS_ANG")
    private String nomPaysAng;
    @Basic
    @Column(name = "NATIONALITE")
    private String nationalite;
    @Basic
    @Column(name = "NOMBRE_HABITANT")
    private int nombreHabitant;
    @Basic
    @Column(name = "SUPERFICIE")
    private int superficie;
    @Basic
    @Column(name = "DEVISE")
    private String devise;
    @Basic
    @Column(name = "FETE_NATIONALE")
    private String feteNationale;
    @Basic
    @Column(name = "INDICATIF_TELEPHONIQUE")
    private String indicatifTelephonique;



    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name ="ID_MONNAIE")
    private List<MonnaieEntity> monnaie;



    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "ID_VISAS")
    private VisasEntity visas;


    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "ID_VILLE")
    private VilleEntity ville;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "ID_CONTINENT")
    private ContinentEntity continent;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "Exiger",
            joinColumns = @JoinColumn(name = "ID_PAYS"),
            inverseJoinColumns = @JoinColumn(name = "ID_SANTE")
    )
    private List<SanteEntity> sante;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "Parler",
            joinColumns = @JoinColumn(name = "ID_PAYS"),
            inverseJoinColumns = @JoinColumn(name = "ID_LANGUES")
    )
    private List<LanguesEntity> langues;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "emporter",
            joinColumns = @JoinColumn(name = "ID_PAYS"),
            inverseJoinColumns = @JoinColumn(name = "ID_OBJET")
    )
    private List<ObjetEntity> objets;
}
