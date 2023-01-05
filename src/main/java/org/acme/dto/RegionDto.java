package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.acme.entities.PaysEntity;
import org.acme.entities.RegionEntity;
import org.acme.entities.TypeClimatEntity;
import org.acme.entities.VilleEntity;
import org.acme.hateaos.HateOas;

@Data
@JsonPropertyOrder({"id","nom", "pays", "typeClimat"})
public class RegionDto  extends HateOas {

    private int id;
    private String nom;

    private Pays pays;

    private TypeClimat typeClimat;

    public RegionDto(RegionEntity regionEntity) {
        id = regionEntity.getIdRegion();
        nom = regionEntity.getNomRegion();
        pays = new Pays(regionEntity.getPays());
        typeClimat = new TypeClimat(regionEntity.getTypeClimat());
    }

    public static RegionDto regionDtoById(RegionEntity regionEntities){
        RegionDto regionDto = new RegionDto(regionEntities);
        return regionDto;
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
}


