package com.customer_tracker.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Customer_SEQ")
    @SequenceGenerator(name = "Customer_SEQ", sequenceName = "CUSTOMER_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private int id;

    @NotNull(message = "This field is required!")
    @Size(min = 3, max = 15, message = "Write something you sucker!")
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotNull(message = "This field is required!")
    @Size(min = 3, max = 15, message = "Write something you sucker!")
    @Column(name = "LAST_NAME")
    private String lastName;

    @NotNull(message = "This field is required!")
    @Size(min = 3, max = 30, message = "Write something you sucker!")
    @Column(name = "EMAIL")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.trim().replaceAll("\\s", "");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.trim().replaceAll("\\s", "");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.trim().replaceAll("\\s", "");
    }

    @Override
    public String toString() {
        return "id = " + id +
                ", firstName = " + firstName + ", lastName = " + lastName + ", email = " + email;
    }
}
