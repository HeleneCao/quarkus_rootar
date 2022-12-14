package org.acme.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.acme.entities.ContinentEntity;
import org.acme.entities.PaysEntity;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaysDto {
    private int id;
    private String nom;
    private Continent continent;


    public PaysDto(PaysEntity paysEntity){
        id = paysEntity.getIdPays();
        nom = paysEntity.getNomPaysFr();
        continent = new Continent(paysEntity.getContinent());

    }



    public static List<PaysDto> toPaysDtoList(List<PaysEntity> paysEntities) {

        List<PaysDto> paysDtoList = new ArrayList<>();
        for (PaysEntity paysEntity : paysEntities) {
            paysDtoList.add(new PaysDto(paysEntity));
        }

        return paysDtoList;
    }
    @Getter
    @Setter
    class Continent{
        private int id;
        private String nom;

        public Continent(ContinentEntity continentEntity) {
            id = continentEntity.getIdContinent();
            nom = continentEntity.getNomContinentFr();
        }
    }

    }