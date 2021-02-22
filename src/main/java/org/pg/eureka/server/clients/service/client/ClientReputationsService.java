package org.pg.eureka.server.clients.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("client-reputations")
public interface ClientReputationsService {

    @GetMapping("/health")
    ResponseEntity<Map<String, String>> getHealth();

    @GetMapping
    ResponseEntity<Integer> getReputation(@RequestParam String cnp);

}
