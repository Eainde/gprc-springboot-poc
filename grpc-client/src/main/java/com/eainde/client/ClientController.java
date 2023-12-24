package com.eainde.client;

import com.eainde.client.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/{message}", produces = "application/json")
    public ResponseEntity<?> findAll(@PathVariable("message") String message) {
        return new ResponseEntity<>(clientService.sayHello(message), HttpStatus.OK);
    }
}
