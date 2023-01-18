package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.acme.entities.UtilisateurEntity;
import org.acme.hateaos.HateOas;
@Data
@JsonPropertyOrder({"login","mail", "role"})
public class UtilisateurDto extends HateOas {

    private String login;
    private String mail;
    private String role;

    public UtilisateurDto(UtilisateurEntity utilisateurEntity) {
        this.login = utilisateurEntity.getLogin();
        this.mail = utilisateurEntity.getMail();
        this.role = utilisateurEntity.getRole();
    }

    public static UtilisateurDto utilisateurDtoById(UtilisateurEntity utilisateurEntities){
        UtilisateurDto utilisateurDto = new UtilisateurDto(utilisateurEntities);
        return utilisateurDto;
    }
}
