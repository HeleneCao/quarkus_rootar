package org.acme.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class ParlerEntityPK implements Serializable {
    @Column(name = "ID_PAYS")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPays;
    @Column(name = "ID_LANGUES")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLangues;


}
