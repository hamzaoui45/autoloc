package com.example.autoloc.controllers;

import com.example.autoloc.entities.Client;
import com.example.autoloc.services.IClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final IClientService clientService;

    @PostMapping
    public Client ajouterClient(@RequestBody Client client) {
        return clientService.ajouterClient(client);
    }

    @PutMapping
    public Client modifierClient(@RequestBody Client client) {
        return clientService.modifierClient(client);
    }

    @GetMapping
    public List<Client> consulterClients() {
        return clientService.consulterClients();
    }

    @GetMapping("/getById/{idClient}")
    public Client getByIdClient(@PathVariable("idClient") Long idClient) {
        return clientService.consulterClientById(idClient);
    }

    @DeleteMapping("/delete/{idClient}")
    public void deleteClient(@PathVariable("idClient") Long idClient) {
        clientService.supprimerClient(idClient);
    }
}