package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.acme.entities.DonneesClimatEntity;
import org.acme.hateaos.HateOas;


@Data
@JsonPropertyOrder({"idregion","mois","temperatureMin","temperatureMax","temperatureMoy","tauxHumidite"})
public class DonneesClimatDto extends HateOas {
    private int idRegion;
    private int mois;

    private String libelleMois;
    private double temperatureMin;
    private double temperatureMax;
    private Double temperatureMoy;
    private int tauxHumidite;

    public DonneesClimatDto(DonneesClimatEntity donneesClimatEntity){
        idRegion=donneesClimatEntity.getIdRegion();
        mois = donneesClimatEntity.getMois();
        temperatureMin = donneesClimatEntity.getTemperatureMin();
        temperatureMoy = donneesClimatEntity.getTemperatureMoy();
        temperatureMax = donneesClimatEntity.getTemperatureMax();
        tauxHumidite = donneesClimatEntity.getTauxHumidite();
    }
    public static DonneesClimatDto dcDtoById(DonneesClimatEntity donneesClimatEntity){
        return new DonneesClimatDto(donneesClimatEntity);
    }
}
