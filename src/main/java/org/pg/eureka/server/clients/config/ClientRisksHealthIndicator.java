package org.pg.eureka.server.clients.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.pg.eureka.server.clients.service.client.ClientIdentityService;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Log4j2
@RequiredArgsConstructor
public class ClientRisksHealthIndicator implements HealthIndicator {

    private final ClientIdentityService client;

    @Override
    public Health getHealth(boolean includeDetails) {
        return health();
    }

    @Override
    public Health health() {
        Health res = null;
        try {
            ResponseEntity<Map<String, String>> resp = client.getHealth();
            if (resp.getStatusCode().is2xxSuccessful()) {
                res = Health.up()
                            .withDetail("Risks service", "reached successfully")
                            .withDetail("Health response code", resp.getStatusCode())
                            .build();
            }
            log.debug("Client Risks service reached successfully");
        } catch (Exception e) {
            res = Health.down()
                        .withDetail("Risks service", "could not be reached")
                        .build();
            log.error("Could not reach songs endpoint", e);
        }
        return res;
    }
}
