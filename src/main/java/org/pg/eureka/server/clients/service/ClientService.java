package org.pg.eureka.server.clients.service;

import lombok.AllArgsConstructor;
import org.pg.eureka.server.clients.dto.ClientCheckResponseDto;
import org.pg.eureka.server.clients.dto.ClientDto;
import org.pg.eureka.server.clients.service.client.ClientReputationsService;
import org.pg.eureka.server.clients.service.client.ClientIdentityService;
import org.pg.eureka.server.clients.utils.enums.EClientReputation;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

@Service
@AllArgsConstructor
public class ClientService {

    private ClientReputationsService clientReputationsService;
    private ClientIdentityService clientIdentityService;

    public ClientCheckResponseDto validateClient(ClientDto clientDto) {
        validateIdentityCardDetails(clientDto);
        int clientRisk = clientReputationsService.getReputation(clientDto.getCnp()).getBody();
        boolean existingClient = clientIdentityService.isExistingClient(clientDto.getCnp()).getBody();

        return ClientCheckResponseDto.builder()
                .identityCardDataValid(true)
                .clientReputation(EClientReputation.getReputation(clientRisk))
                .existingClient(existingClient)
                .build();
    }

    private void validateIdentityCardDetails(ClientDto clientDto) {
        validateCNP(clientDto.getCnp());
        validateAddress(clientDto.getBirthPlace());
        validateAddress(clientDto.getAddress());
        if (clientDto.getValidFrom().equals(clientDto.getValidUntil()))
            throw new ValidationException("Issue date can not be the same as the expire date");
    }

    private void validateAddress(String birthPlace) {
        // todo search for library that performs an address check
    }

    private void validateCNP(String cnp) {
        // todo search library that performs the CNP check
    }

}
