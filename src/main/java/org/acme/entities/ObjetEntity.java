package org.acme.entities;

import lombok.Data;
import org.acme.dto.ObjetDto;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "OBJET", schema = "dbo", catalog = "ROOTAR")
public class ObjetEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_OBJET")
    private int idObjet;
    @Basic
    @Column(name = "LIBELLE_OBJET")
    private String libelleObjet;
   /* @Basic
    @Column(name = "ID_CATEGORIES")
    private int idCategories;*/
    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "ID_CATEGORIES")
    private CategoriesEntity categories;


}
