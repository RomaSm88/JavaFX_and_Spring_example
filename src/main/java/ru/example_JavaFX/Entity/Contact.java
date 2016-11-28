package ru.example_JavaFX.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Random;


/**
 * Created by Рома on 27.11.2016.
 */
@Entity
@Table
public class Contact implements  Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column (unique = true)
    private String phone;

    @Column (unique = true)
    private String email;

    public Contact() {

    }

    public Contact(String name, String phone, String email) {
        this.id = new Random().nextLong();
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
