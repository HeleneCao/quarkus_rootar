package org.acme.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PARLER", schema = "dbo", catalog = "ROOTAR")
@IdClass(ParlerEntityPK.class)
public class ParlerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PAYS")
    private int idPays;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_LANGUES")
    private int idLangues;


}
