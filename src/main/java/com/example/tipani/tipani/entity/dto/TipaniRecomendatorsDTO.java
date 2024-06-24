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
        this.tipaniId =(recomendators.getTipani()!=null)? recomendators.getTipani().getId():null;
        this.employeeId = (recomendators.getEmployee()!=null)? recomendators.getEmployee().getId():null;
        this.position = recomendators.getPosition();
        this.hasRecommends = recomendators.isHasRecommends();
    }

}
