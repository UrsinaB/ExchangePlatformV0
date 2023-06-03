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
import org.springframework.web.server.ResponseStatusException;

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
    @PostMapping(path ="/create/{itemId}/{clientId}" ,consumes = "application/json", produces = "application/json")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment, 
    @PathVariable (value = "itemId") String itemId, 
    @PathVariable (value = "clientId") String clientId) {
        try {
            commentService.createComment(comment, Long.parseLong(itemId), Long.parseLong(clientId));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return new ResponseEntity<Comment>(commentService.createComment(comment, Long.parseLong(itemId), Long.parseLong(clientId)), HttpStatus.CREATED);
    } 
}
    

