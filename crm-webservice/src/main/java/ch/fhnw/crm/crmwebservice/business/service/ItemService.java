package ch.fhnw.crm.crmwebservice.business.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.fhnw.crm.crmwebservice.data.domain.Item;
import ch.fhnw.crm.crmwebservice.data.domain.Item.ItemCategory;
import ch.fhnw.crm.crmwebservice.data.repository.ItemRepository;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;
    private Item item;


    //create and check if item already exists and if no, save new item
    public void saveItem(Item item) {
        itemRepository.save(item);
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

        //find all items with a certain rating
        public List<Item> findAllItemsWithRating(String itemRating) {
            return itemRepository.findByItemRating(itemRating);
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



}


