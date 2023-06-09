package ch.fhnw.crm.crmwebservice.data.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;

@Entity
@Table(name = "transactions")

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "item_id")
    @JsonBackReference("transaction-item")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "offering_user_id")
    @JsonBackReference("offeringUser-transaction")
    private Client offeringUser;

    @ManyToOne
    @JoinColumn(name = "receiving_user_id")
    @JsonBackReference("receivingUser-transaction")
    private Client receivingUser;

    private enum Status {
        PENDING,
        ACCEPTED,
        DECLINED,
        CANCELLED,
        COMPLETED
    }
    @Enumerated(EnumType.STRING)
	private Status status;

    private enum Rating {
        POSITIVE,
        NEGATIVE,
        NEUTRAL
    }

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @Column(name = "transaction_timestamp")
    private LocalDate timestamp;


    @PrePersist
    protected void onCreate() {
        timestamp = LocalDate.now();
    }


    // Constructors, getters, and setters

    public Transaction() {
        // Default constructor
    }

    // Constructor without ID
  // Constructor without ID
    public Transaction(Item item, Client offeringUser, Client receivingUser, Status status, Rating rating, LocalDate timestamp) {
        this.item = item;
        this.offeringUser = offeringUser;
        this.receivingUser = receivingUser;
        this.status = status;
        this.rating = rating;
        this.timestamp = timestamp;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }


    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }
    
    public Client getOfferingUser() {
        return offeringUser;
    }

    public void setOfferingUser(Client offeringUser) {
        this.offeringUser = offeringUser;
    }

    public Client getReceivingUser() {
        return receivingUser;
    }

    public void setReceivingUser(Client receivingUser) {
        this.receivingUser = receivingUser;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }


}


