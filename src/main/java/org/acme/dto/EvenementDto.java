package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.acme.entities.ContinentEntity;
import org.acme.entities.EvenementsEntity;
import org.acme.entities.PaysEntity;
import org.acme.entities.VilleEntity;
import org.acme.hateaos.HateOas;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonPropertyOrder({"id","nom","debut","fin","description"})
public class EvenementDto extends HateOas {

    private int idEvenements;

    private String libelleEvenements;

    private String dateDebutEvenements;

    private String dateFinEvenements;

    private String descriptionEvenement;
    private List<Ville> villes;
    public EvenementDto(EvenementsEntity evenementsEntity){
        idEvenements=evenementsEntity.getIdEvenements();
        libelleEvenements = evenementsEntity.getLibelleEvenements();
        dateDebutEvenements = evenementsEntity.getDateDebutEvenements();
        dateFinEvenements = evenementsEntity.getDateFinEvenements();
        descriptionEvenement = evenementsEntity.getDescriptionEvenement();
        villes=fromVilleDtoList(evenementsEntity.getVilles());
    }
    private List<Ville> fromVilleDtoList(List<VilleEntity> villeEntities) {
        List<Ville> villeList = new ArrayList();
        for (VilleEntity villeEntity : villeEntities){
            villeList.add(new Ville(villeEntity));
        }
        return villeList;
    }
    public static EvenementDto evenementDtoById(EvenementsEntity evenementsEntity){

        return new EvenementDto(evenementsEntity);
    }
    @Data
    public class Ville {
        private int idville;
        private String nomVille;

        public Ville(VilleEntity villeEntity){
            idville=villeEntity.getIdVille();
            nomVille = villeEntity.getNomVille();
        }

    }

}
