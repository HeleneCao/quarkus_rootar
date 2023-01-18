package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.acme.entities.CategoriesEntity;
import org.acme.entities.ObjetEntity;
import org.acme.hateaos.HateOas;

@Data
@JsonPropertyOrder({"id","nom"})
public class ObjetDto extends HateOas {

    private int idObjet;
    private String libelleObjet;

    private Categories categories;
    public ObjetDto(ObjetEntity objetEntity){
        idObjet=objetEntity.getIdObjet();
        libelleObjet=objetEntity.getLibelleObjet();
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
            libelleObjet = categoriesEntity.getLibelleCategories();
        }

    }
}
