package org.acme.dto;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.acme.entities.ThemesEntity;
import org.acme.hateaos.HateOas;
@Data
@JsonPropertyOrder({"id","nom"})
public class ThemesDto extends HateOas {

        private int idThemes;
        private String libThemes;

    public ThemesDto(ThemesEntity themesEntity){
        idThemes=themesEntity.getIdTheme();
        libThemes=themesEntity.getLibelleTheme();
    }
    public static ThemesDto themesDtoById(ThemesEntity themesEntity){
        ThemesDto themesDto= new ThemesDto(themesEntity);
        return themesDto;
    }
}
