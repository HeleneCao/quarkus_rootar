package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.acme.entities.CategoriesEntity;
import org.acme.entities.TypeClimatEntity;
import org.acme.hateaos.HateOas;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonPropertyOrder({"id","nom"})
public class TypeClimatDto extends HateOas {
    private int idTypeClimat;
    private String libTypeClimat;

    public TypeClimatDto(TypeClimatEntity typeClimatEntity){
        idTypeClimat=typeClimatEntity.getIdTypeClimat();
        libTypeClimat=typeClimatEntity.getLibelleTypeClimat();
    }
    public static List<TypeClimatDto> toTypeClimatDtoList(List<TypeClimatEntity> typeClimatEntities){
        List<TypeClimatDto> typeClimatsDtoList = new ArrayList<>();
        for (TypeClimatEntity typeClimatEntity : typeClimatEntities){
            typeClimatsDtoList.add(new TypeClimatDto(typeClimatEntity));
        }
        return typeClimatsDtoList;
    }
    public static TypeClimatDto typeClimatDtoById(TypeClimatEntity typeClimatEntity){
       TypeClimatDto typeClimatDto = new TypeClimatDto(typeClimatEntity);

        return typeClimatDto;
    }

}
