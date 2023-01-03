package org.acme.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
@Data
@Entity
@Table(name = "LANGUES", schema = "dbo", catalog = "ROOTAR")
public class LanguesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_LANGUES")
    private int idLangues;
    @Basic
    @Column(name = "LIBELLE_LANGUES")
    private String libelleLangues;

}
