package ch.fhnw.crm.crmwebservice.data.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String text;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Client client;

    public Comment() {
    }

    public Comment(String commentText, Item item, Client client) {
        this.text = commentText;
        this.item = item;
        this.client = client;
    }

    public Long getCommentId() {
        return this.id;
    }

    public void setCommentId(Long commentId) {
        this.id = commentId;
    }

    public String getCommentText() {
        return this.text;
    }

    public void setCommentText(String commentText) {
        this.text = commentText;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
        }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;

    }

    }
    

