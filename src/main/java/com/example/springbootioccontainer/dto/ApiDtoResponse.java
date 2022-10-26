package com.example.springbootioccontainer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public class ApiDtoResponse {
    private String cido;
    private String gun;
    private String dong;


    public ApiDtoResponse(String cido, String gun, String dong)
    {
        this.cido = cido;
        this.gun = gun;
        this.dong = dong;
    }

//    private ApiDtoResponse(ApiEntity entity){
//        this.cido = entity.getCido();
//        this.dong = entity.getDong();
//        this.gun = entity.getGun();
//    }
//
//    public static ApiDtoResponse of(ApiEntity entity){
//        return new ApiDtoResponse(entity);
//    }
}
