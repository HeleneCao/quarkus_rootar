package org.acme.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "CATEGORIES", schema = "dbo", catalog = "ROOTAR")
public class CategoriesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_CATEGORIES")
    private int idCategories;
    @Basic
    @Column(name = "LIBELLE_CATEGORIES")
    private String libelleCategories;


}
