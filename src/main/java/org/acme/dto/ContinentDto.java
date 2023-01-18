package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.acme.entities.ContinentEntity;
import org.acme.entities.PaysEntity;
import org.acme.hateaos.HateOas;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonPropertyOrder({"id","nom"})
public class ContinentDto extends HateOas {

    private int id;
    private String nom;
    private List<Pays> pays;

    public ContinentDto(ContinentEntity continentEntity){
        id = continentEntity.getIdContinent();
        nom = continentEntity.getNomContinentFr();
        pays = fromPaysDtoList(continentEntity.getPays());
    }

    private List<Pays> fromPaysDtoList(List<PaysEntity> paysEntities) {
        List<Pays> paysList = new ArrayList();
        for (PaysEntity paysEntity : paysEntities){
            paysList.add(new Pays(paysEntity));
        }
        return paysList;
    }

    public static List<ContinentDto> toContinentDtoList(List<ContinentEntity> continentEntities){
        List<ContinentDto> continentDtoList = new ArrayList<>();
        for (ContinentEntity continentEntity : continentEntities){
            continentDtoList.add(new ContinentDto(continentEntity));
        }
        return continentDtoList;
    }

    public static ContinentDto continentDtoById(ContinentEntity continentEntities){
        ContinentDto continentDto = new ContinentDto(continentEntities);
        return continentDto;
    }

    @Data
    @JsonPropertyOrder({"id","nom"})
    class Pays extends HateOas{
        private int id;
        private String nom;

        public Pays(PaysEntity paysEntity){
            id= paysEntity.getIdPays();
            nom = paysEntity.getNomPaysFr();
        }
    }
}