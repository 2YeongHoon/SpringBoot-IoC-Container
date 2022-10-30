package com.example.springbootioccontainer;

import com.example.springbootioccontainer.dto.ApiDtoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
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
    public ResponseEntity retrievePosition(
        @RequestParam(name = "xpos") String xpos,
        @RequestParam(name = "ypos") String ypos
    ) throws Exception {
        ApiDtoResponse apiDto = apiService.getCoords(xpos, ypos);
        if (ObjectUtils.isEmpty(apiDto)){
            ResponseEntity.notFound();
        }

        return ResponseEntity.ok(apiDto);
    }
}
