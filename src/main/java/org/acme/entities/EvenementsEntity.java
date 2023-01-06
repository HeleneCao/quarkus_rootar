package org.acme.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "EVENEMENTS", schema = "dbo", catalog = "ROOTAR")
public class EvenementsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_EVENEMENTS")
    private int idEvenements;
    @Basic
    @Column(name = "LIBELLE_EVENEMENTS")
    private String libelleEvenements;
    @Basic
    @Column(name = "DATE_DEBUT_EVENEMENTS")
    private String dateDebutEvenements;
    @Basic
    @Column(name = "DATE_FIN_EVENEMENTS")
    private String dateFinEvenements;
    @Basic
    @Column(name = "DESCRIPTION_EVENEMENT")
    private String descriptionEvenement;
    /*@Basic
    @Column(name = "ID_VILLE")
    private int idVille;*/
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn (name = "ID_VILLE")
    private List<VilleEntity> villes;


}
