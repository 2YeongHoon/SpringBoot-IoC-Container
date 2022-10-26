package com.example.springbootioccontainer;

import com.example.springbootioccontainer.dto.ApiDtoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hi")
@RestController
@RequiredArgsConstructor
public class ApiController {

    private final ApiService apiService;

    @GetMapping(value = "/position")
    public void retrievePosition(
        @RequestParam(name = "xpos") String xpos,
        @RequestParam(name = "ypos") String ypos
    ) {
        ApiDtoResponse apiDto = ApiDtoResponse.builder().build();
        apiService.getCoords(xpos, ypos);
    }
}
