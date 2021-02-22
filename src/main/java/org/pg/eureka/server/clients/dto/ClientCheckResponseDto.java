package org.pg.eureka.server.clients.dto;

import lombok.Builder;
import lombok.Data;
import org.pg.eureka.server.clients.utils.enums.EClientReputation;

@Data
@Builder
public class ClientCheckResponseDto {
    private boolean identityCardDataValid;
    private EClientReputation clientReputation;
    private boolean existingClient;
}
