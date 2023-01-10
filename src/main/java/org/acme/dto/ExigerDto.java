package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.acme.entities.ExigerEntity;
import org.acme.entities.LanguesEntity;
import org.acme.entities.PaysEntity;
import org.acme.hateaos.HateOas;


@Data
@JsonPropertyOrder({"idPays,idSante"})
public class ExigerDto extends HateOas {

    private int idPays;

    private int idSante;

    public ExigerDto(ExigerEntity exigerEntity){

        idPays=exigerEntity.getIdPays();
        idSante=exigerEntity.getIdSante();


    }

    public static ExigerDto exigerDtoById(ExigerEntity exigerEntity){
        ExigerDto exigerDto = new ExigerDto(exigerEntity);
        return exigerDto;
    }

    @Data
    @JsonPropertyOrder({"id","nom"})
    class Pays{
        private int id;
        private String nom;

        public Pays(PaysEntity paysEntity){
            id= paysEntity.getIdPays();
            nom = paysEntity.getNomPaysFr();
        }
    }
}
