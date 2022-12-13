package org.acme.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="CONTINENT", schema="dbo", catalog="rootar")
public class ContinentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_CONTINENT")
    private Integer idContinent;

    @Column (name="NOM_CONTINENT_FR")
    private String nomContinentfr;

}
