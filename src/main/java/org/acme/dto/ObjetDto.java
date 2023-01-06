package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.acme.entities.CategoriesEntity;
import org.acme.entities.ObjetEntity;
import org.acme.entities.PaysEntity;
import org.acme.hateaos.HateOas;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonPropertyOrder({"id","nom"})
public class ObjetDto extends HateOas {

    private int idObjet;
    private String libObjet;

    private Categories categories;
    public ObjetDto(ObjetEntity objetEntity){
        idObjet=objetEntity.getIdObjet();
        libObjet=objetEntity.getLibelleObjet();
        categories= new Categories(objetEntity.getCategories());


    }
    public static ObjetDto objetDtoById(ObjetEntity objetEntity){
        ObjetDto objetDto= new ObjetDto(objetEntity);
        return objetDto;
    }

    @Data
    public class Categories{
        private int idCat;
        private String libCat;

        public Categories(CategoriesEntity categoriesEntity){
            idCat=categoriesEntity.getIdCategories();
            libObjet = categoriesEntity.getLibelleCategories();
        }

    }
}
