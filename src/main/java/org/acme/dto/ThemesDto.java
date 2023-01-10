package org.acme.dto;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.acme.entities.PaysEntity;
import org.acme.entities.ThemesEntity;
import org.acme.hateaos.HateOas;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonPropertyOrder({"id","nom"})
public class ThemesDto extends HateOas {

        private int idThemes;
        private String libThemes;
 private List<Pays> pays;
    public ThemesDto(ThemesEntity themesEntity){
        idThemes=themesEntity.getIdTheme();
        libThemes=themesEntity.getLibelleTheme();
        pays = fromPaysDtoList(themesEntity.getPays());
    }
    public static ThemesDto themesDtoById(ThemesEntity themesEntity){
        ThemesDto themesDto= new ThemesDto(themesEntity);
        return themesDto;
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
