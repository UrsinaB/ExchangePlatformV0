package ch.fhnw.crm.crmwebservice.business.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import ch.fhnw.crm.crmwebservice.data.domain.Comment;
import ch.fhnw.crm.crmwebservice.data.repository.CommentRepository;
import jakarta.validation.Valid;

@Service
public class CommentService {

 @Autowired
 private CommentRepository commentRepository;

 @Autowired
private ItemService itemService;

@Autowired
private ClientService clientService;

 
 //create a new comment for an item by a client with text
 public Comment createComment(@Valid Comment comment, Long itemId, Long clientId) {
        if (itemId != null && clientId != null) {
            comment.setItem(itemService.getItemById(itemId));
            comment.setClient(clientService.getCurrentUser(clientId));
        }
            
            return commentRepository.save(comment);
    }
}


