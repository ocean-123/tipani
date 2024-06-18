package com.example.tipani.tipani.entity.dto;


import com.example.tipani.tipani.entity.TipaniRecomendators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipaniRecomendatorsDTO {

    private Long id;
    private Long tipaniId;
    private Long employeeId;
    private String position;
    private boolean hasRecommends;

    public  TipaniRecomendatorsDTO(TipaniRecomendators recomendators){
        this.id = recomendators.getId();
        this.tipaniId = recomendators.getTipani().getId();
        this.employeeId = recomendators.getEmployee().getId();
        this.position = recomendators.getPosition();
        this.hasRecommends = recomendators.isHasRecommends();
    }

}
