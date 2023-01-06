package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.acme.entities.TypeVisaEntity;
import org.acme.hateaos.HateOas;

@Data
@JsonPropertyOrder({"id","nom"})
public class TypeVisasDto extends HateOas {

    private int id;
    private String nom;

    public TypeVisasDto(TypeVisaEntity typeVisasEntity) {
        id = typeVisasEntity.getIdTypeVisa();
        nom = typeVisasEntity.getLibelleTypeVisa();
    }

    public static TypeVisasDto typeVisasDtoById(TypeVisaEntity typeVisasEntities){
        TypeVisasDto typeVisasDto = new TypeVisasDto(typeVisasEntities);
        return typeVisasDto;
    }
}
