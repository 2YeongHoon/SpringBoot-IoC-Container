package com.example.springbootioccontainer.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Data
@RequiredArgsConstructor
public class ApiJsonResponse{

    private Response response;
    private Result result;
    private Structure structure;
    private String text;

    @Data
    static class Response{
        private String status;
        private List<Result> result;
    }

    @Data
    static class Result {
        private String text;
        private Structure structure;
    }

    @Data
    static class Structure{
        private String level0;
        private String level1;
        private String level2;
        private String level3;
        private String level4L;
        private String level4LC;
        private String level4A;
        private String level4AC;
        private String level5;
        private String detail;
    }
}
