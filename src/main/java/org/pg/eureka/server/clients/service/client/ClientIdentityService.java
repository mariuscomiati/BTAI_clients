package org.pg.eureka.server.clients.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("client-identity")
public interface ClientIdentityService {

    @GetMapping("/health")
    ResponseEntity<Map<String, String>> getHealth();

    @GetMapping
    ResponseEntity<Boolean> isExistingClient(@RequestParam String cnp);

}
