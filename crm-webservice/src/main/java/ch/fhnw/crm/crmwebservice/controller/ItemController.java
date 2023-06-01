package ch.fhnw.crm.crmwebservice.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ch.fhnw.crm.crmwebservice.business.service.ItemService;
import ch.fhnw.crm.crmwebservice.data.domain.Item;
import ch.fhnw.crm.crmwebservice.data.domain.Item.ItemCategory;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.ConstraintViolationException;

@RestController
@RequestMapping("api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;
    
     //POST method to add a new item to the database and to relate it to a specific user 
    @PostMapping (path = "/create/{clientId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Item> createItem(@RequestBody Item item, @PathVariable(value = "clientId") String clientId) {
        try {
            itemService.createItem(item, Long.parseLong(clientId));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.ok(item);
    }




    //PUT method to update an existing item in the database by its id -> TESTED WORKS
    @PutMapping(path = "/{itemId}")
    public ResponseEntity<Void> putProfile(@RequestBody Item item, @PathVariable(value = "itemId") String itemId) {
        try {
            item.setItemId(Long.parseLong(itemId));
            itemService.updateItem(item);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.ok().build();
    }
    

    //DELETE method to delete an existing item from the database by its id -> TESTED WORKS
    @DeleteMapping(path = "/delete/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable(value = "itemId") String itemId) {
        try {
            itemService.deleteItem(Long.parseLong(itemId));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    //GET method to retrieve all items listed on a certain date from the database

    //GET method to count all items from the database -> TESTED WORKS
    @GetMapping(path = "/count", produces = "application/json")
    public ResponseEntity<Long> countItems() {
        Long count = itemService.countAllItems();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    //GET method to retrieve all items with a certain status from the database

    //GET method to retrieve all items with a certain rating from the database

    //GET method to search for items by title and description using keywords from the database -> TESTED WORKS
    @GetMapping(path = "search/{keyword}", produces = "application/json") 
    public ResponseEntity<List<Item>> searchItems(@PathVariable(value = "keyword") String keyword) {
        List<Item> items = itemService.searchForItemsByTitleAndDescription(keyword);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    //GET method to retrieve all items from the database -> TESTED WORKS
    @GetMapping(path = "/all", produces = "application/json")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }


    //GET method to retriev all items that belong to a specific item category -> TESTED WORKS
     @GetMapping(path = "/category/{itemCategory}", produces = "application/json")
    public ResponseEntity<List<Item>> getItemByCategory(@PathVariable(value = "itemCategory") ItemCategory itemCategory) {
            List<Item> items = itemService.findByItemCategory(itemCategory);
            return new ResponseEntity<>(items, HttpStatus.OK);
        }

    //GET method to count all items belonging to a specific item category -> TESTED WORKS
    @GetMapping(path = "/category/count/{itemCategory}", produces = "application/json")
    public ResponseEntity<Long> countItemsByCategory(@PathVariable(value = "itemCategory") ItemCategory itemCategory) {
        Long count = itemService.countAllItemsByItemCategory(itemCategory);
        return new ResponseEntity<>(count, HttpStatus.OK);  
        
    }

    //GET method to retrieve all items that belong to a specific client
    @GetMapping(path = "/client/{clientId}", produces = "application/json")
    public ResponseEntity<List<Item>> getItemByClient(@PathVariable(value = "clientId") Long clientId) {
        List<Item> items = itemService.getItemsbyClient(clientId);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    //GET method to retrieve an item by its id
    @GetMapping(path = "/{itemId}", produces = "application/json")
    public ResponseEntity<Item> getItemById(@PathVariable(value = "itemId") Long itemId) {
        Item item = itemService.getItemById(itemId);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    
    @Hidden
    @RequestMapping(value = "/validate", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ResponseEntity<Void> init() {
        return ResponseEntity.ok().build();
    }
    


}
    
    
    
