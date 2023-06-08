package ch.fhnw.crm.crmwebservice.business.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import ch.fhnw.crm.crmwebservice.data.domain.Client;
import ch.fhnw.crm.crmwebservice.data.domain.Item;
import ch.fhnw.crm.crmwebservice.data.domain.Item.ItemCategory;
import ch.fhnw.crm.crmwebservice.data.repository.ItemRepository;
import jakarta.validation.Valid;


@Service
@Validated
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ClientService clientService;


    // create item and assign it to the current client (user)
    
public Item createItem(@Valid Item item, Long clientId) throws Exception {
    if (item.getItemId() == null) {
            item.setClient(clientService.getCurrentUser(clientId));
        if (itemRepository.findByItemTitleAndItemIdNot(item.getItemTitle(), item.getItemId()) != null) {
            throw new Exception("Title " + item.getItemTitle() + " already assigned to an item.");
        }
        if (item.getClient() == null) {
            item.setClient(clientService.getCurrentUser(clientId));
        }
    }
    return itemRepository.save(item);
}



    //get all items
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

        //update item
         public void updateItem(Item item) {
        itemRepository.save(item);
    }

        //delete item
        public void deleteItem(Long itemId) {
        itemRepository.deleteById(itemId);
        }

        //delete all items
        public void deleteAllItems() {
            itemRepository.deleteAll();
        }

        //find all item listed on a certain date
		public List<Item> findAllItemsListedOnDate(Date date) {
			return itemRepository.findByItemListingDate(date);
		}

        //find all items belonging to a specific item category 
        public List<Item> findByItemCategory(ItemCategory itemCategory) {
            return itemRepository.findByItemCategory(itemCategory);
        }

        //count all items on the platform belonging to a specific item category
        public long countAllItemsByItemCategory(ItemCategory itemCategory) {
            return itemRepository.countByItemCategory(itemCategory);
        }

        // count all items on the platform
		public long countAllItems() {
			return itemRepository.count();
		}

        //find all items with a certain status
        public List<Item> findAllItemsWithStatus(Item.ItemStatus itemStatus) {
            return itemRepository.findByItemStatus(itemStatus);
        }



        // search for items by title and description using keywords

		public List<Item> searchForItemsByTitleAndDescription(String keyword) {

			List<Item> items = new ArrayList <> ();
			String[] keywords =keyword.split("\\s+");
			for (String k : keywords) {
				List<Item> itemList = itemRepository.findByItemTitleContainingOrItemDescriptionContainingIgnoreCase (k, k);
				items.addAll(itemList);
			}

			return items;
		}

        // find all items assigned to a specific client
        public List<Item> getItemsbyClient(Long clientId) {
            return itemRepository.findByClientId(clientId);

        }



        public Item getItemById(Long itemId) {
            return itemRepository.findByItemId(itemId);
        }





}


