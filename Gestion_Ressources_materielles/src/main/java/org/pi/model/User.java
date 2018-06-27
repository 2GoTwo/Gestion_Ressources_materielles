package org.pi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="user")
@DiscriminatorColumn(name="TYPE_CPTE")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer utilisateurId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String userName;
	private String adress;
	private String role;
	private String description;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dateAjout = new Date();
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(User user) {
		this.adress = user.adress;
		this.utilisateurId = user.utilisateurId;
		this.firstName = user.firstName;
		this.lastName =  user.lastName;
		this.password = user.password;
		this.email = user.email;
		this.description = user.description;
	}
	public User(org.springframework.boot.autoconfigure.security.SecurityProperties.User user) {
		// TODO Auto-generated constructor stub
	}
	public Integer getUtilisateurId() {
		return utilisateurId;
	}
	public void setUtilisateurId(Integer utilisateurId) {
		this.utilisateurId = utilisateurId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String username) {
		this.userName = username;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
