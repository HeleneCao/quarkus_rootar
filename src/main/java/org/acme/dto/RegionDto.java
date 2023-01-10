package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.acme.entities.*;
import org.acme.hateaos.HateOas;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonPropertyOrder({"id","nom", "pays", "typeClimat"})
public class RegionDto  extends HateOas {

    private int id;
    private String nom;

    private Pays pays;

    private TypeClimat typeClimat;

    private List<Themes> themes;

    public RegionDto(RegionEntity regionEntity) {
        id = regionEntity.getIdRegion();
        nom = regionEntity.getNomRegion();
        pays = new Pays(regionEntity.getPays());
        typeClimat = new TypeClimat(regionEntity.getTypeClimat());
        themes = fromThemesDtoList(regionEntity.getThemes());
    }

    public static RegionDto regionDtoById(RegionEntity regionEntities){
        RegionDto regionDto = new RegionDto(regionEntities);
        return regionDto;
    }

    private List<Themes> fromThemesDtoList(List<ThemesEntity> themesEntities) {
        List<Themes> themesList = new ArrayList();
        for (ThemesEntity themesEntity : themesEntities){
            themesList.add(new Themes(themesEntity));
        }
        return themesList;
    }

    @Data
    class Pays{
        private int id;
        private String nom;


        public Pays(PaysEntity paysEntity) {
            id = paysEntity.getIdPays();
            nom = paysEntity.getNomPaysFr();
        }
    }

    @Data
    class TypeClimat{
        private int id;
        private String nom;


        public TypeClimat(TypeClimatEntity typeClimatEntity) {
            id = typeClimatEntity.getIdTypeClimat();
            nom = typeClimatEntity.getLibelleTypeClimat();
        }
    }

    @Data
    class Themes {
        private int idThemes;

        private String libelleTheme;
        public Themes(ThemesEntity themesEntity){
            idThemes = themesEntity.getIdTheme();
            libelleTheme = themesEntity.getLibelleTheme();
        }
    }
}


