package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.acme.entities.CategoriesEntity;
import org.acme.entities.ContinentEntity;
import org.acme.hateaos.HateOas;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonPropertyOrder({"id","nom"})
public class CategoriesDto extends HateOas {

    private int idCat;
    private String libCat;

        public CategoriesDto (CategoriesEntity categoriesEntity){
            idCat=categoriesEntity.getIdCategories();
            libCat = categoriesEntity.getLibelleCategories();
        }
    public static List<CategoriesDto> toCatDtoList(List<CategoriesEntity> categoriesEntities){
        List<CategoriesDto> categoriesDtoList = new ArrayList<>();
        for (CategoriesEntity categoriesEntity : categoriesEntities){
            categoriesDtoList.add(new CategoriesDto(categoriesEntity));
        }
        return categoriesDtoList;
    }
    public static CategoriesDto categoriesDtoById(CategoriesEntity categoriesEntity){
        CategoriesDto categoriesDto= new CategoriesDto(categoriesEntity);

        return categoriesDto;
    }
}
