package ch.fhnw.crm.crmwebservice.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.crm.crmwebservice.data.domain.Client;
import ch.fhnw.crm.crmwebservice.data.domain.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByStatus(String status);
    List<Transaction> findByOfferingUser(Long offeringUserId);
    List<Transaction> findByReceivingUser(Long receivingUserId);
    
}

