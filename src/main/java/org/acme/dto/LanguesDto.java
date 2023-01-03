package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.acme.entities.ContinentEntity;
import org.acme.entities.LanguesEntity;
import org.acme.hateaos.HateOas;

@Data
@JsonPropertyOrder({"id","nom"})
public class LanguesDto extends HateOas {

    private int id;
    private String nom;

    public LanguesDto(LanguesEntity languesEntity) {
        id = languesEntity.getIdLangues();
        nom = languesEntity.getLibelleLangues();
    }


}
