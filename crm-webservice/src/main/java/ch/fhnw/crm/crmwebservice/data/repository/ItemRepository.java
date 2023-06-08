package ch.fhnw.crm.crmwebservice.data.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.crm.crmwebservice.data.domain.Item;
import ch.fhnw.crm.crmwebservice.data.domain.Item.ItemCategory;

@Repository

public interface ItemRepository extends JpaRepository<Item, Long>{

    //find all items listed by a certain date
    List<Item> findByItemListingDate(Date itemListingDate);

    //find all items with a certain status
    List<Item> findByItemStatus(Item.ItemStatus itemStatus);

    //find all items belonging to a certein item category
    List<Item> findByItemCategory(ItemCategory itemCategory);

    // Find all items with a title containing the given search string, sorted by listing date in ascending order
    List<Item> findByItemTitleContainingIgnoreCaseOrderByItemListingDateAsc(String itemTitle);

    //find all tiems with a description conatining the given search string, sorted by listing date in ascending order
    List<Item> findByItemDescriptionContainingIgnoreCaseOrderByItemListingDateAsc(String itemDescription);

    //find all items
	List<Item> findAll();

    //Count all items
	long count();

    //count all items by item category
    long countByItemCategory(ItemCategory itemCategory);

	//Delete item by title
	void deleteByItemTitle(String itemTitle);

    //search for items by title and description using keywords
    List<Item> findByItemTitleContainingOrItemDescriptionContainingIgnoreCase(String itemTitle, String itemDescription);

    Item findByItemTitle(String itemTitle);

    Item findByItemTitleAndItemIdNot(String itemTitle, Long itemId);

    List<Item> findByClientId(Long clientId);

    Item findByItemId(Long itemId);
}
