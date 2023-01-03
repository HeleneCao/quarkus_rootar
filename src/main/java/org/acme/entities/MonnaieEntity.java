package org.acme.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
@Data
@Entity
@Table(name = "MONNAIE", schema = "dbo", catalog = "ROOTAR")
public class MonnaieEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_MONNAIE")
    private int idMonnaie;
    @Basic
    @Column(name = "LIBELLE_MONNAIE")
    private String libelleMonnaie;

    @OneToMany (fetch = FetchType.LAZY)
    @JoinColumn (name = "ID_MONNAIE")
    private List<PaysEntity> pays;


}
