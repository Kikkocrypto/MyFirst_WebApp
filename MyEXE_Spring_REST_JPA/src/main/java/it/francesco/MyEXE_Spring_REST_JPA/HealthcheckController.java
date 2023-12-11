package it.francesco.MyEXE_Spring_REST_JPA;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthcheckController {

    @GetMapping("/health")
    public String Healthcheck() {
        System.out.println("HEALTHCHECK FIRE!!");
        return "OK";
    }
}
