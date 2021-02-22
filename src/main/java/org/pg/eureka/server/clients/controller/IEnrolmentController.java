package org.pg.eureka.server.clients.controller;

import org.pg.eureka.server.clients.dto.ClientDto;
import org.springframework.http.ResponseEntity;

public interface IEnrolmentController {

    // this should be optimized so that the full check doesn't run twice
    // for now caching is an option, based on the complete requirements there might be other options as well
    ResponseEntity<byte[]> generateEnrolmentDocument(ClientDto clientDto);
    ResponseEntity<byte[]> generateDenialDocument(ClientDto clientDto);
}
