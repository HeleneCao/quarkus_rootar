package org.acme.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "AEROPORT", schema = "dbo", catalog = "ROOTAR")
public class AeroportEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_AEROPORT")
    private int idAeroport;
    @Basic
    @Column(name = "LIBELLE_AEROPORT")
    private String libelleAeroport;
    @Basic
    @Column(name = "ADRESSE")
    private String adresse;
    @Basic
    @Column(name = "TELEPHONE")
    private String telephone;
   /* @Basic
    @Column(name = "ID_VILLE")
    private int idVille;*/
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "ID_VILLE")
    private VilleEntity ville;

}
