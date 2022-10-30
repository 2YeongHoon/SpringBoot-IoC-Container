package com.example.springbootioccontainer.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiJsonResponse{

    public Response response;

    @Data
    public class Response{
        private String status;
        private List<Result> result;
    }

    @Data
    public class Result {
        private String text;
        private Structure structure;
    }

    @Data
    public class Structure{
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
