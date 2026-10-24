package com.example.autoloc.controllers;

import com.example.autoloc.entities.Client;
import com.example.autoloc.services.IClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("client")
@RestController
public class ClientController {
    private final IClientService clientService;

    @PostMapping("/ajout")
    public Client ajouterClient(@RequestBody Client client) {
        return clientService.ajouterClient(client);
    }

    @PutMapping("/modifier")
    public Client modifierClient(@RequestBody Client client) {
        return clientService.modifierClient(client);
    }

    @GetMapping("/consulter")
    public List<Client> getall() {
        return clientService.consulterClients();
    }

    @GetMapping("/getById/{idClient}")
    public Client getClientById(@PathVariable Long idClient) {
        return clientService.consulterClientById(idClient);
    }

    @DeleteMapping("/delete/{idClient}")
    public void deleteById(@PathVariable Long idClient) {
        clientService.supprimerClientById(idClient);
    }
}
