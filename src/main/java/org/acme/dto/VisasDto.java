package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.acme.entities.TypeVisaEntity;
import org.acme.entities.VisasEntity;
import org.acme.hateaos.HateOas;

@Data
@JsonPropertyOrder({"id","dureeValidite", "delaiObtention","prixVisas", "typeVisa"})
public class VisasDto extends HateOas {

    private int id;
    private int dureeValidite;
    private int delaiObtention;
    private double prixVisas;
    private TypeVisa typeVisa;

    public VisasDto(VisasEntity visasEntity) {
        id = visasEntity.getIdVisas();
        dureeValidite = visasEntity.getDureeValidite();
        delaiObtention = visasEntity.getDelaiObtention();
        prixVisas = visasEntity.getPrixVisas();
        typeVisa = new TypeVisa(visasEntity.getTypeVisa());
    }

    public static VisasDto visasDtoById(VisasEntity visasEntities){
        VisasDto visasDto = new VisasDto(visasEntities);

        return visasDto;
    }

    @Data
    class TypeVisa{
        private int id;
        private String nom;

        public TypeVisa(TypeVisaEntity typeVisatEntity) {
            id = typeVisatEntity.getIdTypeVisa();
            nom = typeVisatEntity.getLibelleTypeVisa();
        }
    }
}
