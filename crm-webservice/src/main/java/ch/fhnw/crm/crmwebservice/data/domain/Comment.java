package ch.fhnw.crm.crmwebservice.data.domain;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @Hidden
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int commentId;

    
    private String text;

    @ManyToOne
    @JoinColumn(name = "item_id")
    @JsonBackReference("comment - item")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("comment - client")
    private Client client;

    public Comment() {
    }

    public Comment(int commentId, String text, Item item, Client client) {
        this.commentId = commentId;
        this.text = text;
        this.item = item;
        this.client = client;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
        }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;

    }

    }
    

