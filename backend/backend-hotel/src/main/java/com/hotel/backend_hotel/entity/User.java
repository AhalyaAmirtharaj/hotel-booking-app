package com.hotel.backend_hotel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//@Entity means this class is a database table
//@Data from Lombok auto-creates getters and setters
@Data
@Entity
@Table(name = "users")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;
private String email;
private String password; // will be encrypted before saving
private String phone;
private String address; // default delivery address
public User(Long id, String name, String email, String password, String phone, String address) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.password = password;
	this.phone = phone;
	this.address = address;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}

}
