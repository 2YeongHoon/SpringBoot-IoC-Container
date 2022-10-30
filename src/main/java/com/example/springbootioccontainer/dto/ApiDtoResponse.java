package com.example.springbootioccontainer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ApiDtoResponse {
    private String cido;
    private String gun;
    private String dong;

    private ApiDtoResponse(ApiJsonResponse entity){
        this.cido = entity.getResponse().getResult().get(0).getStructure().getLevel1();
        this.dong = entity.getResponse().getResult().get(0).getStructure().getLevel2();
        this.gun = entity.getResponse().getResult().get(0).getStructure().getLevel3();
    }

    public static ApiDtoResponse of(ApiJsonResponse entity){
        return new ApiDtoResponse(entity);
    }
}
