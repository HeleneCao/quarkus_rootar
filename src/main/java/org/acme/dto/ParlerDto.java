package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.acme.entities.ParlerEntity;
import org.acme.entities.TypeClimatEntity;
import org.acme.hateaos.HateOas;

@Data
@JsonPropertyOrder({"id","nom"})
public class ParlerDto extends HateOas {

    private int idPays;
    private int idLangues;


    public ParlerDto(ParlerEntity parlerEntity){
        idPays = parlerEntity.getIdPays();
        idLangues = parlerEntity.getIdLangues();

    }

    public static ParlerDto parlerDtoById(ParlerEntity parlerEntity){
        ParlerDto parlerDto = new ParlerDto(parlerEntity);

        return parlerDto;
    }



}
