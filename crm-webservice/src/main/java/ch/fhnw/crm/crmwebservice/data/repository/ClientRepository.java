package ch.fhnw.crm.crmwebservice.data.repository;

import ch.fhnw.crm.crmwebservice.data.domain.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByEmail(String email);
	Client findByEmailAndIdNot(String email, Long clientId);
	Client findByEmailAndIdAndNameNot(String email, Long clientId, String name);
}
