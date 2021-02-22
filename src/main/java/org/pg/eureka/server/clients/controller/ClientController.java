package org.pg.eureka.server.clients.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.pg.eureka.server.clients.dto.ClientCheckResponseDto;
import org.pg.eureka.server.clients.dto.ClientDto;
import org.pg.eureka.server.clients.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.ValidationException;

@Log4j2
@RestController
@AllArgsConstructor
public class ClientController {

    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientCheckResponseDto> validateNewClient(@RequestBody @Valid ClientDto clientDto) {
        log.info(clientDto);
        ResponseEntity<ClientCheckResponseDto> result;
        try {
            result = ResponseEntity.ok(clientService.validateClient(clientDto));
        } catch (ValidationException exception) {
            result = ResponseEntity.badRequest().body(ClientCheckResponseDto.builder()
                    .identityCardDataValid(false)
                    .build());
            exception.printStackTrace();
        } catch (Exception exception) {
            result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            exception.printStackTrace();
        }
        return result;
    }
}
