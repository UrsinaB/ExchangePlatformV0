package ch.fhnw.crm.crmwebservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ch.fhnw.crm.crmwebservice.business.service.TransactionService;
import ch.fhnw.crm.crmwebservice.data.domain.Client;
import ch.fhnw.crm.crmwebservice.data.domain.Comment;
import ch.fhnw.crm.crmwebservice.data.domain.Transaction;

@RestController
@RequestMapping("api/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping (path = "/create/{itemId}/{offeringUserId}/{receivingUserId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction,
            @PathVariable (value = "itemId") Long itemId,
            @PathVariable (value = "offeringUserId") Long offeringUserId,
            @PathVariable (value = "receivingUserId") Long receivingUserId) {
           
        Transaction createdTransaction = transactionService.createTransaction(transaction, itemId, offeringUserId, receivingUserId);{
        return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
        }
    }


     // find all transactions
    @GetMapping(path = "/findAll", produces = "application/json")
public ResponseEntity<List<Transaction>> findAllTransactions() {
    List<Transaction> transactions = transactionService.findAllTransactions();
    return new ResponseEntity<>(transactions, HttpStatus.OK);
}

// find all transactions by the id of the offering user
@GetMapping(path = "/findByOfferingUserId/{offeringUserId}", produces = "application/json")
public ResponseEntity<List<Transaction>> findTransactionByOfferingUserId(@PathVariable (value = "offeringUserId") Long offeringUserId) {
    List<Transaction> transactions = transactionService.findTransactionByOfferingUserId(offeringUserId);
    return new ResponseEntity<>(transactions, HttpStatus.OK);

}

@DeleteMapping(path = "/deleteAll")
public ResponseEntity<Void> deleteAllTransactions() {
    try {
        transactionService.deleteAllTransactions();
    } catch (Exception e) {
        System.out.println(e.getStackTrace());
        throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
    }
    return ResponseEntity.ok().build();
}

// find all transactions by the id of the receiving user
@GetMapping(path = "/findByReceivingUserId/{receivingUserId}", produces = "application/json")
public ResponseEntity<List<Transaction>> findTransactionByReceivingUserId(@PathVariable (value = "receivingUserId") Long receivingUserId) {
    List<Transaction> transactions = transactionService.findTransactionByReceivingUserId(receivingUserId);
    return new ResponseEntity<>(transactions, HttpStatus.OK);
}

@PatchMapping("/updateTransaction")
public Transaction updateTransaction(@RequestBody Transaction transaction) {
    return transactionService.updateTransaction(transaction);
}


}