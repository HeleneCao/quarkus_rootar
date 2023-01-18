package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.acme.entities.*;
import org.acme.hateaos.HateOas;
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

    private List<Sante> sante;

    private List<Langues> langues;
    private List<Objet> objets;

    private List<Themes> themes;



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
        sante = fromSanteDtoList(paysEntity.getSante());
        langues = fromLanguesDtoList(paysEntity.getLangues());
        objets = fromobjetsDtoList(paysEntity.getObjets());
        themes = fromThemesDtoList(paysEntity.getThemes());
    }

    private List<Themes> fromThemesDtoList(List<ThemesEntity> themesEntities) {
        List<Themes> themesList = new ArrayList();
        for (ThemesEntity themesEntity : themesEntities){
            themesList.add(new Themes(themesEntity));
        }
        return themesList;
    }
    private List<Objet> fromobjetsDtoList(List<ObjetEntity> objetEntities) {
        List<Objet> objetsList = new ArrayList();
        for (ObjetEntity objetEntity : objetEntities){
            objetsList.add(new Objet(objetEntity));
        }
        return objetsList;
    }
    private List<Langues> fromLanguesDtoList(List<LanguesEntity> languesEntities) {
        List<Langues> languesList = new ArrayList();
        for (LanguesEntity languesEntity : languesEntities){
            languesList.add(new Langues(languesEntity));
        }
        return languesList;
    }
    private List<Sante> fromSanteDtoList(List<SanteEntity> santeEntities) {
        List<Sante> santeList = new ArrayList();
        for (SanteEntity santeEntity : santeEntities){
            santeList.add(new Sante(santeEntity));
        }
        return santeList;
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

    public static PaysDto paysDtoById(PaysEntity paysEntity){
        PaysDto paysDto = new PaysDto(paysEntity);
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
    @Data
    class Sante{
        private int idSante;

        private String libelleSante;
        public Sante (SanteEntity santeEntity){
            idSante=santeEntity.getIdSante();
            libelleSante = santeEntity.getLibelleSante();
        }
    }

    @Data
    class Langues{
        private int idLangues;
        private String libelleLangues;

        public Langues(LanguesEntity languesEntity){
            idLangues=languesEntity.getIdLangues();
            libelleLangues=languesEntity.getLibelleLangues();
        }


    }
    @Data
    class Objet {
        private int idObjet;

        private String libelleObjet;
        public Objet(ObjetEntity objetEntity){
            idObjet = objetEntity.getIdObjet();
            libelleObjet = objetEntity.getLibelleObjet();
        }
    }

    @Data
    class Themes {
        private int idThemes;

        private String libelleTheme;
        public Themes(ThemesEntity themesEntity){
            idThemes = themesEntity.getIdTheme();
            libelleTheme = themesEntity.getLibelleTheme();
        }
    }
}