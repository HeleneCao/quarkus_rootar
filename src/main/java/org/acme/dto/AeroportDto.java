package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.acme.entities.AeroportEntity;
import org.acme.entities.VilleEntity;
import org.acme.hateaos.HateOas;



@Data
@JsonPropertyOrder({"id","nom","adresse","telephone"})
public class AeroportDto extends HateOas {

    private int idAeroport;
    private String libelleAeroport;
    private String adresse;
    private String telephone;
    private Ville ville;
    public AeroportDto(AeroportEntity aeroportEntity){
        idAeroport = aeroportEntity.getIdAeroport();
        libelleAeroport = aeroportEntity.getLibelleAeroport();
        adresse = aeroportEntity.getAdresse();
        telephone = aeroportEntity.getTelephone();
        ville = new Ville(aeroportEntity.getVille());
    }
    public static AeroportDto aeroportDtoById(AeroportEntity aeroportEntity){
        return new AeroportDto(aeroportEntity);
    }
    @Data
    public class Ville{
        private int idVille;
        private String nomVille;

        public Ville(VilleEntity villeEntity){
            idVille = villeEntity.getIdVille();
            nomVille = villeEntity.getNomVille();

        }
    }
}
