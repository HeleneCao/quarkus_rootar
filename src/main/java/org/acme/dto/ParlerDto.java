package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.acme.entities.ParlerEntity;
import org.acme.entities.PaysEntity;
import org.acme.entities.VilleEntity;
import org.acme.hateaos.HateOas;

import java.util.List;

@Data
@JsonPropertyOrder({"idPays","idLangues"})
public class ParlerDto extends HateOas {

    private int idPays;
    private int idLangues;




    public ParlerDto(ParlerEntity parlerEntity){
        idPays = parlerEntity.getIdPays();
        idLangues = parlerEntity.getIdLangues();



    }

    public static ParlerDto parlerDtoById(ParlerEntity parlerEntity){
        return new ParlerDto(parlerEntity);
    }


}
