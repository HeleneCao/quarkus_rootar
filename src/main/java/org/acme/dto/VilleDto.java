package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.acme.entities.PaysEntity;
import org.acme.entities.RegionEntity;
import org.acme.entities.VilleEntity;
import org.acme.hateaos.HateOas;

@Data
@JsonPropertyOrder({"id","nom", "region"})
public class VilleDto extends HateOas {

    private int id;
    private String nom;

    public VilleDto(VilleEntity villeEntity) {
        id = villeEntity.getIdVille();
        nom = villeEntity.getNomVille();
    }

    public static VilleDto villeDtoById(VilleEntity villeEntities){
        VilleDto villeDto = new VilleDto(villeEntities);
        return villeDto;
    }

    @Data
    @JsonPropertyOrder({"id", "nom"})
    class Pays extends HateOas {
        private int id;
        private String nom;

        public Pays(PaysEntity paysEntity) {
            id = paysEntity.getIdPays();
            nom = paysEntity.getNomPaysFr();
        }
    }

  @Data
    class Region{
        private int id;
        private String nom;

        public Region(RegionEntity regionEntity) {
            id = regionEntity.getIdRegion();
            nom = regionEntity.getNomRegion();
        }
    }

}


