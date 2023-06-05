package ch.fhnw.crm.crmwebservice.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ch.fhnw.crm.crmwebservice.business.service.ClientService;
import ch.fhnw.crm.crmwebservice.business.service.CommentService;
import ch.fhnw.crm.crmwebservice.business.service.ItemService;
import ch.fhnw.crm.crmwebservice.data.domain.Comment;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ItemService itemService;

    // create comment
    @PostMapping(path = "/create/{itemId}/{clientId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment,
            @PathVariable(value = "itemId") Long itemId,
            @PathVariable(value = "clientId") Long clientId) {
        if (itemId != null && clientId != null) {
            comment.setItem(itemService.getItemById(itemId));
            comment.setClient(clientService.getCurrentUser(clientId));
        }
    
        Comment createdComment = commentService.createComment(comment, itemId, clientId);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }
    
    
    

    // update exisiting comment. Id is passed as path varible, new text is passed as JSON and return updated comment
    @PutMapping("/update/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable int commentId, @RequestBody CommentUpdateDTO commentUpdateDTO) {
        Comment comment = commentService.findCommentById(commentId);
        if (comment == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found");
        }
        comment.setText(commentUpdateDTO.getText());
        commentService.updateComment(commentId, commentUpdateDTO.getText());
        return new ResponseEntity<>(comment, HttpStatus.OK);
        
    }

    // delete all comments
    @DeleteMapping(path = "/deleteAll")
    public void deleteAllComments() {
        commentService.deleteAllComments();
    }

    // find comment by id
    @GetMapping(path = "/{commentId}", produces = "application/json")
    public ResponseEntity<Comment> findCommentById(@PathVariable(value = "commentId") int commentId){
        Comment comment = commentService.findCommentById(commentId);
        return new ResponseEntity<>(comment, HttpStatus.OK); 
    }

    // find all comments
    @GetMapping(path = "/findAll", produces = "application/json")
public ResponseEntity<List<Comment>> findAllComments() {
    List<Comment> comments = commentService.findAllComments();
    return new ResponseEntity<>(comments, HttpStatus.OK);
}
  

    public static class CommentUpdateDTO {
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}











    

