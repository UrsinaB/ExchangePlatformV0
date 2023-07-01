package ch.fhnw.crm.crmwebservice.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import ch.fhnw.crm.crmwebservice.data.domain.Client;
import ch.fhnw.crm.crmwebservice.data.repository.ClientRepository;



import jakarta.validation.Valid;
import jakarta.validation.Validator;

@Service
@Validated
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    Validator validator;
    
    @Autowired
    PasswordEncoder passwordEncoder;


    public void saveUser(@Valid Client client) throws Exception {
        if (client.getId() == null) {
            if (clientRepository.findByEmail(client.getEmail()) != null) {
                throw new Exception("Email address " + client.getEmail() + " already assigned another user.");
            }
        } else if (clientRepository.findByEmailAndIdAndNameNot(client.getEmail(), client.getId(),client.getName()) != null) {
            throw new Exception("Email address " + client.getEmail() + " and name " + client.getName() + " already assigned another user.");
        }
        // client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientRepository.save(client);
    }

    public Client updateClient(Client client){
        Client existingClient = clientRepository.findById(client.getId()).orElse(null);
        existingClient.setName(client.getName());
        existingClient.setFirstName(client.getFirstName());
        existingClient.setLastName(client.getLastName());
        existingClient.setEmail(client.getEmail());
        return clientRepository.save(existingClient);
    }
    
    public void deleteUser(Long clientId) {
		clientRepository.deleteById(clientId);
	}

    // public void deleteClient(Client client){
    //     Client existingClient = clientRepository.findById(client.getId()).orElse(null);
	// 	clientRepository.delete(existingClient);
	// }
	

	public List<Client> getAllUsers() {
        return clientRepository.findAll();
    }

    public Client getCurrentUser(Long clientId) {
        Client client = clientRepository.findById(clientId).get();
        return client;
    }

    //delete all clients
    public void deleteAllClients() {
        clientRepository.deleteAll();
    }


    

}