package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.acme.entities.*;
import org.acme.hateaos.HateOas;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonPropertyOrder({"id","nom", "codePays","nomPaysFr", "nomPaysAng", "nationalite", "nombreHabitant", "superficie", "devise", "feteNationale", "indicatifTelephonique"})
public class PaysDto extends HateOas {
    private int id;
    private String nom;
    private Continent continent;

    private String codePays;

    private String nomPaysFr;

    private String nomPaysAng;

    private String nationalite;

    private int nombreHabitant;

    private int superficie;

    private String devise;

    private String feteNationale;

    private String indicatifTelephonique;

    private List<Monnaie> monnaie;

    private Ville ville;

    private Visas visas;



    public PaysDto(PaysEntity paysEntity){
        id = paysEntity.getIdPays();
        nom = paysEntity.getNomPaysFr();
        continent = new Continent(paysEntity.getContinent());
        codePays = paysEntity.getCodePays();
        nomPaysFr = paysEntity.getNomPaysFr();
        nomPaysAng = paysEntity.getNomPaysAng();
        nationalite = paysEntity.getNationalite();
        nombreHabitant = paysEntity.getNombreHabitant();
        superficie = paysEntity.getSuperficie();
        devise = paysEntity.getDevise();
        feteNationale = paysEntity.getFeteNationale();
        indicatifTelephonique = paysEntity.getIndicatifTelephonique();
        monnaie = fromMonnaieDtoList(paysEntity.getMonnaie());
        ville = new Ville(paysEntity.getVille());
        visas = new Visas(paysEntity.getVisas());
    }


    private List<Monnaie> fromMonnaieDtoList(List<MonnaieEntity> monnaieEntities) {
        List<Monnaie> monnaieList = new ArrayList();
        for (MonnaieEntity monnaieEntity : monnaieEntities){
            monnaieList.add(new Monnaie(monnaieEntity));
        }
        return monnaieList;
    }
    public static List<PaysDto> toPaysDtoList(List<PaysEntity> paysEntities) {

        List<PaysDto> paysDtoList = new ArrayList<>();
        for (PaysEntity paysEntity : paysEntities) {
            paysDtoList.add(new PaysDto(paysEntity));
        }

        return paysDtoList;
    }

    public static PaysDto paysDtoById(PaysEntity paysEntities){
        PaysDto paysDto = new PaysDto(paysEntities);
        return paysDto;
    }

    @Data
    class Continent{
        private int id;
        private String nom;

        public Continent(ContinentEntity continentEntity) {
            id = continentEntity.getIdContinent();
            nom = continentEntity.getNomContinentFr();
        }
    }

    @Data
    class Monnaie{
        private int id;
        private String nom;

        public Monnaie(MonnaieEntity monnaieEntity) {
            id = monnaieEntity.getIdMonnaie();
            nom = monnaieEntity.getLibelleMonnaie();
        }
    }



    @Data
    class Ville{
        private int id;
        private String nom;

        public Ville(VilleEntity villeEntity) {
            id = villeEntity.getIdVille();
            nom = villeEntity.getNomVille();
        }
    }

    @Data
    class Visas{
        private int id;
        private int dureeValidite;
        private int delaiObtention;
        private double prixVisas;



        public Visas(VisasEntity visasEntity) {
            id = visasEntity.getIdVisas();
            dureeValidite = visasEntity.getDureeValidite();
            delaiObtention = visasEntity.getDelaiObtention();
            prixVisas = visasEntity.getPrixVisas();

        }
    }

    }