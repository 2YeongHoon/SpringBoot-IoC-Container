package com.example.springbootioccontainer;

import com.example.springbootioccontainer.dto.ApiDtoResponse;
import com.example.springbootioccontainer.dto.ApiJsonResponse;
import com.example.springbootioccontainer.dto.ApiJsonResponse.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class ApiService {

    @Value("${custom.external.vworld.url}")
    private String VWORLD_URL;

    @Value("${custom.external.vworld.uri}")
    private String VWORLD_URI;

    @Value("${custom.external.vworld.service}")
    private String VWORLD_SERVICE;

    @Value("${custom.external.vworld.request}")
    private String VWORLD_REQUEST;

    @Value("${custom.external.vworld.version}")
    private String VWORLD_VERSION;

    @Value("${custom.external.vworld.crs}")
    private String VWORLD_CRS;

    @Value("${custom.external.vworld.format}")
    private String VWORLD_FORMAT;

    @Value("${custom.external.vworld.type}")
    private String VWORLD_TYPE;

    @Value("${custom.external.vworld.zipcode}")
    private String VWORLD_ZIPCODE;

    @Value("${custom.external.vworld.simple}")
    private String VWORLD_SIMPLE;

    @Value("${custom.external.vworld.key}")
    private String VWORLD_KEY;

    public ApiDtoResponse getCoords(String xpos, String ypos) throws Exception {

        ApiJsonResponse apiJsonResponse = WebClient.create(VWORLD_URL)
            .get()
            .uri(uriBuilder ->
                uriBuilder.path(VWORLD_URI)
                    .queryParam("service", VWORLD_SERVICE)
                    .queryParam("request", VWORLD_REQUEST)
                    .queryParam("version", VWORLD_VERSION)
                    .queryParam("crs", VWORLD_CRS)
                    .queryParam("point", xpos + "," + ypos)
                    .queryParam("format", VWORLD_FORMAT)
                    .queryParam("type", VWORLD_TYPE)
                    .queryParam("zipcode", VWORLD_ZIPCODE)
                    .queryParam("simple", VWORLD_SIMPLE)
                    .queryParam("key", VWORLD_KEY)
                    .build()
            )
            .retrieve()
            .bodyToMono(ApiJsonResponse.class)
            .block();

        System.out.println(apiJsonResponse);

        return checkResultStatus(apiJsonResponse);
    }

    private ApiDtoResponse checkResultStatus(ApiJsonResponse apiJsonResponse) throws Exception {
        Response response = apiJsonResponse.getResponse();
        ApiJsonResponse.Result result = response.getResult().get(0);
//        ApiDtoResponse res = new ApiDtoResponse();

        if ("OK".equals(response.getStatus())) {
            return ApiDtoResponse.of(apiJsonResponse);
        }

        if ("NOT_FOUND".equals(response.getStatus())) {
            return null;
        }

        if ("ERROR".equals(response.getStatus())) {
            throw new Exception();
        }
        return null;

    }
}
