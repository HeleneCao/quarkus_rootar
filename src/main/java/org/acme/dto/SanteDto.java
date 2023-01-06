package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.acme.entities.ObjetEntity;
import org.acme.entities.PrioriteEntity;
import org.acme.entities.SanteEntity;
import org.acme.hateaos.HateOas;
@Data
@JsonPropertyOrder({"id","nom"})
public class SanteDto extends HateOas {
    private int idSante;
    private String libSante;

    private Priorite priorite;
    public SanteDto (SanteEntity santeEntity){
        idSante=santeEntity.getIdSante();
        libSante=santeEntity.getLibelleSante();
        priorite=new Priorite(santeEntity.getPriorite());
    }
    public static SanteDto santeDtoById(SanteEntity santeEntity){
        SanteDto santeDto= new SanteDto(santeEntity);
        return santeDto;
    }
    @Data
    public class Priorite{
        private int idPriorite;
        private String libPriorite;

        public Priorite (PrioriteEntity priorite){
            idPriorite=priorite.getIdPriorite();
            libPriorite=priorite.getLibellePriorite();
        }
    }

}
