package org.acme.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="PRIORITE", schema="dbo", catalog="rootar")
public class PrioriteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_PRIORITE")
    private Integer idPriorite;

    @Column (name="LIBELLE_PRIORITE")
    private String libellePriorite;
}
