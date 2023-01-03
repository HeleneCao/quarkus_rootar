package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.acme.entities.ContinentEntity;
import org.acme.entities.PaysEntity;
import org.acme.entities.VilleEntity;
import org.acme.hateaos.HateOas;
@Data
@JsonPropertyOrder({"id","nom"})
public class VilleDto extends HateOas {

    private int id;
    private String nom;

    public VilleDto(VilleEntity villeEntity) {
        id = villeEntity.getIdVille();
        nom = villeEntity.getNomVille();


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

}


