package com.example.springbootioccontainer;

import com.example.springbootioccontainer.dto.ApiJsonResponse;
import com.fasterxml.jackson.core.JsonParser;
import java.net.URL;
import jdk.nashorn.internal.parser.JSONParser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import lombok.extern.slf4j.Slf4j;

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

    public void getCoords(String xpos, String ypos) {

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
        // TODO 파싱 후 반환로직 작성
        apiJsonResponse.getResponse();
//        checkResultStatus(apiJsonResponse);
    }

    // TODO status 검증 로직 작성
//    private boolean checkResultStatus(ApiJsonResponse apiJsonResponse) {
//        JSONParser jsonParser = new JSONParser();
//
//
//
//        System.out.println(apiJsonResponse.getText());
//        apiJsonResponse.getResponse()
//        Object b = apiJsonResponse;
//
//        return true;
//    }



}
