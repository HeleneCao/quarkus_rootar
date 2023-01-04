package org.acme.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
@Data
@Entity
@Table(name = "VISAS", schema = "dbo", catalog = "ROOTAR")
public class VisasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_VISAS")
    private int idVisas;
    @Basic
    @Column(name = "DUREE_VALIDITE")
    private int dureeValidite;
    @Basic
    @Column(name = "DELAI_OBTENTION")
    private int delaiObtention;
    @Basic
    @Column(name = "PRIX_VISAS")
    private double prixVisas;


    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "ID_TYPE_VISA")
    private TypeVisaEntity typeVisa;

}
