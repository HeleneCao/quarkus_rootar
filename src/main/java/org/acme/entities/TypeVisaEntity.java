package org.acme.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "TYPE_VISA", schema = "dbo", catalog = "ROOTAR")
public class TypeVisaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_TYPE_VISA")
    private int idTypeVisa;
    @Basic
    @Column(name = "LIBELLE_TYPE_VISA")
    private String libelleTypeVisa;


}
