package org.acme.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "SANTE", schema = "dbo", catalog = "ROOTAR")
public class SanteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_SANTE")
    private int idSante;
    @Basic
    @Column(name = "LIBELLE_SANTE")
    private String libelleSante;
    /*@Basic
    @Column(name = "ID_PRIORITE")
    private int idPriorite;*/
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "ID_PRIORITE")
    private PrioriteEntity priorite;



}
