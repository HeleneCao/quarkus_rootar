package org.acme.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "EXIGER", schema = "dbo", catalog = "ROOTAR")
@IdClass(ExigerEntityPK.class)
public class ExigerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PAYS")
    private int idPays;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_SANTE")
    private int idSante;


}
