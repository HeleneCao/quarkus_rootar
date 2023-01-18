package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.acme.entities.PrioriteEntity;
import org.acme.hateaos.HateOas;
@Data
@JsonPropertyOrder({"id","nom"})
public class PrioriteDto extends HateOas {
    private int id;
    private String nom;

    public PrioriteDto(PrioriteEntity prioriteEntity) {
        id = prioriteEntity.getIdPriorite();
        nom = prioriteEntity.getLibellePriorite();
    }

    public static PrioriteDto prioriteDtoById(PrioriteEntity prioriteEntities){
        PrioriteDto prioriteDto = new PrioriteDto(prioriteEntities);
        return prioriteDto;
    }
}
