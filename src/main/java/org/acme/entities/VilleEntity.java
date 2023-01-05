package org.acme.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "VILLE", schema = "dbo", catalog = "ROOTAR")
public class VilleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_VILLE")
    private int idVille;
    @Basic
    @Column(name = "NOM_VILLE")
    private String nomVille;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "ID_REGION")
    private RegionEntity region;

}
