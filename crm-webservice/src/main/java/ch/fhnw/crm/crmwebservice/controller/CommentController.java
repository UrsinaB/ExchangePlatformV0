package ch.fhnw.crm.crmwebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.fhnw.crm.crmwebservice.business.service.ClientService;
import ch.fhnw.crm.crmwebservice.business.service.CommentService;
import ch.fhnw.crm.crmwebservice.data.domain.Comment;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ClientService clientService;

    // create comment
    @PostMapping("/create/{itemId}/{clientId}")
    public ResponseEntity<Comment> createComment(
    @RequestBody @Valid Comment comment, 
    @PathVariable Long itemId,
    @PathVariable Long clientId
    ) {
        try {
            Comment createdComment = commentService.createComment(comment, itemId, clientId);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } 
    }
    
    
}
