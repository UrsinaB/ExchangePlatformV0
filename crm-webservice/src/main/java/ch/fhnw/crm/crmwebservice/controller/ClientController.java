package ch.fhnw.crm.crmwebservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import ch.fhnw.crm.crmwebservice.business.service.ClientService;
import ch.fhnw.crm.crmwebservice.data.domain.Client;
import io.swagger.v3.oas.annotations.Hidden;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> postRegister(@RequestBody Client client) {
        try {
            clientService.saveUser(client);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateClient")
    public Client updateClient(@RequestBody Client client) {
        return clientService.updateClient(client);
    }

    @GetMapping("/allusers")
    public List<Client> all() {
       return clientService.getAllUsers();
    }

    @GetMapping("/profile/{clientId}")
    public @ResponseBody Client getProfile(@PathVariable(value = "clientId") String clientId) {
        return clientService.getCurrentUser(Long.parseLong(clientId));
    } 

    @PutMapping("/profile/{clientId}")
    public ResponseEntity<Void> putProfile(@RequestBody Client client, @PathVariable(value = "clientId") String clientId) {
        try {
            client.setId(Long.parseLong(clientId));
            clientService.saveUser(client);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

  

//delete all clients
    @DeleteMapping("/deleteall")
    public ResponseEntity<Void> deleteAll() {
        try {
            clientService.deleteAllClients();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.ok().build();
    }


    @Hidden
    @RequestMapping(value = "/validate", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ResponseEntity<Void> init() {
        return ResponseEntity.ok().build();
    }
    
}
