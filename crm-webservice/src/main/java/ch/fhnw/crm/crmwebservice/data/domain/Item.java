package ch.fhnw.crm.crmwebservice.data.domain;


import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDate;

// declaring a database relation items (the item to be exchanged)
@Entity 
// specifying the name of the database table associated with the entity 
@Table(name = "items")

public class Item {

    
    // declaring the primary key of the table
    @Id
    // declaring that the primary key is generated automatically
    @GeneratedValue
    // declaring that the primary key should not be visible in the API
	@Column(name = "item_id")
    private Long itemId;

    // declaring the attributes of the table
    
    private String itemTitle;


    @NotEmpty(message ="Please provide a description for your item")
    //declaring the maximum length of the attribute
	@Column(length = 1000)
	private String itemDescription;

    // declaring the attribute as LocalDate that is automatically generated
    @Column(name = "itemListingDate")
    private LocalDate itemListingDate;

    @PrePersist
    protected void onCreate() {
        itemListingDate = LocalDate.now();
    }


    //enum for item status

    public enum ItemStatus {
        AVAILABLE, UNAVAILABLE
}

    // declaring the attribute as an enumeration
    @Enumerated(EnumType.STRING)
	private ItemStatus itemStatus;




	// enum for item category
	public enum ItemCategory {
		MUSIC,
		CLOTHES,
		ELECTRONICS,
		FURNITURE,
		SPORTS,
		BEAUTY,
		TOYS,
		JEWELRY,
		PETS,
		BOOKS,
		OTHER
	}

	@Enumerated(EnumType.STRING)
	private ItemCategory itemCategory;


	@ManyToOne
	@JsonBackReference
	private Client client;

	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
	@JsonManagedReference("comment-item")
	private List<Comment> comments;


	@OneToOne (mappedBy = "item")
	@JsonManagedReference("transaction-item")
	private Transaction transaction;


    // declaring the getters and setters for the attributes



    public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
	  this.itemId = itemId;
	}

    public String getItemTitle() {
		return itemTitle;
	}

	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

    public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

    public LocalDate getItemListingDate() {
		return itemListingDate;
	}

	public void setItemListingDate(LocalDate itemListingDate) {
		this.itemListingDate = itemListingDate;
	}

    
	public ItemStatus getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(ItemStatus itemStatus) {
		this.itemStatus = itemStatus;
	}


	public ItemCategory getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(ItemCategory itemCategory) {
		this.itemCategory= itemCategory;
	}
    

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	// public List<Comment> getComments() {
	// 	return comments;
	// }

	public String getComments(){
		String commentString = "";
		for(Comment c : comments){
			commentString += c.getText();
			commentString += "\n";
		}
		return commentString;
	}

	public void setComments(List<Comment> comments) {
		this.comments= comments;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
}
