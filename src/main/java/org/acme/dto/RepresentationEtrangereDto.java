package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.acme.entities.LanguesEntity;
import org.acme.entities.PaysEntity;
import org.acme.entities.RepresentationEtrangereEntity;
import org.acme.entities.VilleEntity;
import org.acme.hateaos.HateOas;



@Data
@JsonPropertyOrder({"id","nom","telephone","adresse"})
public class RepresentationEtrangereDto extends HateOas {

    private int idRepresentation;

    private String libelleRepresentation;

    private String telephone;

    private String adresse;
    private Ville ville;
    private Pays pays;
    public RepresentationEtrangereDto(RepresentationEtrangereEntity representationEtrangereEntity){
        idRepresentation=representationEtrangereEntity.getIdRepresentation();
        libelleRepresentation = representationEtrangereEntity.getLibelleRepresentation();
        telephone = representationEtrangereEntity.getTelephone();
        adresse = representationEtrangereEntity.getAdresse();
        ville = new Ville(representationEtrangereEntity.getVille());
        pays = new Pays(representationEtrangereEntity.getPays());

    }
    public static RepresentationEtrangereDto repEtrDtoById(RepresentationEtrangereEntity representationEtrangereEntities){

        return new RepresentationEtrangereDto(representationEtrangereEntities);
    }
    @Data
    public class Ville{
        private int idville;
        private String nomVille;

        public Ville(VilleEntity villeEntity){
            idville=villeEntity.getIdVille();
            nomVille = villeEntity.getNomVille();
        }
    }
    @Data
    @JsonPropertyOrder({"id","nom"})
    class Pays extends HateOas {
        private int id;
        private String nom;

        public Pays(PaysEntity paysEntity){
            id= paysEntity.getIdPays();
            nom = paysEntity.getNomPaysFr();
        }
    }

}
