package ch.fhnw.crm.crmwebservice.business.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.fhnw.crm.crmwebservice.data.domain.Comment;
import ch.fhnw.crm.crmwebservice.data.domain.Transaction;
import ch.fhnw.crm.crmwebservice.data.repository.ClientRepository;
import ch.fhnw.crm.crmwebservice.data.repository.ItemRepository;
import ch.fhnw.crm.crmwebservice.data.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import ch.fhnw.crm.crmwebservice.business.service.ItemService;



@Service



public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final ClientRepository clientRepository;
    private final ItemRepository itemRepository;

    public TransactionService(TransactionRepository transactionRepository, ClientRepository clientRepository, ItemRepository itemRepository) {
        this.transactionRepository = transactionRepository;
        this.clientRepository = clientRepository;
        this.itemRepository = itemRepository;
    }

    @Autowired
private ItemService itemService;

@Autowired
private ClientService clientService;

    @Transactional
public Transaction createTransaction(@Valid Transaction transaction, Long itemId, Long offeringUserId, Long receivingUserId) {
    // Retrieve the item, offering user, and receiving user from the repositories
    transaction.setItem(itemService.getItemById(itemId));
    transaction.setOfferingUser(clientService.getCurrentUser(offeringUserId));
    transaction.setReceivingUser(clientService.getCurrentUser(receivingUserId));

    // Save the transaction
    return transactionRepository.save(transaction);
}

    //find all transactions 
    public List<Transaction> findAllTransactions() {
        return transactionRepository.findAll();
    }

    //find all transactions by the id of the offering user
    public List<Transaction> findTransactionByOfferingUserId(Long offeringUserId) {
        return transactionRepository.findByOfferingUser(offeringUserId);
    }

    //find all transactions by the id of the receiving user
    public List<Transaction> findTransactionByReceivingUserId(Long receivingUserId) {
        return transactionRepository.findByReceivingUser(receivingUserId);
    }
}
 
