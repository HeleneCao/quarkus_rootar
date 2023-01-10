package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.acme.entities.LanguesEntity;
import org.acme.entities.PaysEntity;
import org.acme.hateaos.HateOas;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonPropertyOrder({"id","nom"})
public class LanguesDto extends HateOas {

    private int id;
    private String nom;
    private List<Pays> pays;

    public LanguesDto(LanguesEntity languesEntity) {
        id = languesEntity.getIdLangues();
        nom = languesEntity.getLibelleLangues();
        pays = fromPaysDtoList(languesEntity.getPays());
    }

    public static LanguesDto languesDtoById(LanguesEntity languesEntities){
        LanguesDto languesDto = new LanguesDto(languesEntities);
        return languesDto;
    }
    private List<Pays> fromPaysDtoList(List<PaysEntity> paysEntities) {
        List<Pays> paysList = new ArrayList();
        for (PaysEntity paysEntity : paysEntities){
            paysList.add(new Pays(paysEntity));
        }
        return paysList;
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
