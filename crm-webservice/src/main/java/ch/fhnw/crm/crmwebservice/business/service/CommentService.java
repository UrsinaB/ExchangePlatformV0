package ch.fhnw.crm.crmwebservice.business.service;

import java.util.UUID;
import java.util.List;

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
            comment.setText(comment.getText());
        }
            
            return commentRepository.save(comment);
    }

    //find a comment by its id
    public Comment findCommentById(int commentId) {
        return commentRepository.findByCommentId(commentId);
    }

   //update the text of an existing comment
   public void updateComment(int commentId, String newText) {
        Comment comment = commentRepository.findByCommentId(commentId);
        comment.setText(newText);
        commentRepository.save(comment);
    }

    //delete all comments
    public void deleteAllComments() {
        commentRepository.deleteAll();
    }

    //delete a comment by its id
    public void deleteCommentById(int commentId) {
        commentRepository.deleteByCommentId(commentId);
    }

    //find all comments
    public List<Comment> findAllComments() {
        return commentRepository.findAll();
    }


   
    
}
    


