package ch.fhnw.crm.crmwebservice.data.domain;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @JsonIgnore
	private String role = "USER";
	@Transient // will not be stored in DB

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "client")
    private List<Item> items;

    @OneToMany(mappedBy = "client")
    @JsonManagedReference("comment-client")
    private List<Comment> comments;

    @OneToMany(mappedBy = "offeringUser")
    @JsonManagedReference("offeringUser-transaction")
    private List<Transaction> offeredTransactions;

    @OneToMany(mappedBy = "receivingUser")
    @JsonManagedReference("receivingUser-transaction")
    private List<Transaction> receivedTransactions;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getRole() {
		return role;
	}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Item> getCgetItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

    public List<Comment> getComments() {
        return comments;

    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Client(String name, String firstName, String lastName, String email, String password) {
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Client() {
    }

    public List<Transaction> getOfferedTransactions() {
        return offeredTransactions;
    }

    public void setOfferedTransactions(List<Transaction> offeredTransactions) {
        this.offeredTransactions = offeredTransactions;
    }

    public List<Transaction> getReceivedTransactions() {
        return receivedTransactions;
    }

    public void setReceivedTransactions(List<Transaction> receivedTransactions) {
        this.receivedTransactions = receivedTransactions;
    }

    
}
