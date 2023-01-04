package org.acme.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
@Data
@Entity
@Table(name = "TYPE_CLIMAT", schema = "dbo", catalog = "ROOTAR")
public class TypeClimatEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_TYPE_CLIMAT")
    private int idTypeClimat;
    @Basic
    @Column(name = "LIBELLE_TYPE_CLIMAT")
    private String libelleTypeClimat;


}
