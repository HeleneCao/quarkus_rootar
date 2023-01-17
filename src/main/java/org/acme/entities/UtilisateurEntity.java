package org.acme.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
@Data
@Entity
@Table(name = "UTILISATEUR", schema = "dbo", catalog = "ROOTAR")
public class UtilisateurEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "LOGIN")
    private String login;
    @Basic
    @Column(name = "MAIL")
    private String mail;
    @Basic
    @Column(name = "NOM")
    private String nom;
    @Basic
    @Column(name = "PASSWORD")
    private String password;
    @Basic
    @Column(name = "PRENOM")
    private String prenom;
    @Basic
    @Column(name = "ROLE")
    private String role;


}
