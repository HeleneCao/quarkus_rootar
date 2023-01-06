package org.acme.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "REPRESENTATION_ETRANGERE", schema = "dbo", catalog = "ROOTAR")
public class RepresentationEtrangereEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_REPRESENTATION")
    private int idRepresentation;
    @Basic
    @Column(name = "LIBELLE_REPRESENTATION")
    private String libelleRepresentation;
    @Basic
    @Column(name = "TELEPHONE")
    private String telephone;
    @Basic
    @Column(name = "ADRESSE")
    private String adresse;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "ID_VILLE")
    private VilleEntity ville;
   @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "ID_PAYS")
    private PaysEntity pays;

}
