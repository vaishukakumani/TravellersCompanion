package com.travellerApp.entities;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "users")
public class User {

  // The entity fields (private)  
  
  @NotNull
  @Column(name="user_name",unique=true)
  private String userName;
  
  @Id
  @Column(name="user_id")
  @GeneratedValue(strategy=GenerationType.SEQUENCE)
  private Integer userId;
  
  @NotNull
  @Column(name="password")
  private String password;
  
  @Column(name="first_name")
  private String firstName;
 

@Column(name="last_name")
  private String lastName;

@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(name = "user_role", joinColumns
        = @JoinColumn(name = "user_id",
        referencedColumnName = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id",
                referencedColumnName = "id"))
private List<Role> roles;
  



  // Public methods
  
  public List<Role> getRoles() {
	return roles;
}



public void setRoles(List<Role> roles) {
	this.roles = roles;
}



public String getUserName() {
	return userName;
}



public void setUserName(String userName) {
	this.userName = userName;
}



public String getPassword() {
	return password;
}



public void setPassword(String password) {
	this.password = password;
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

public Integer getUserId() {
	return userId;
}

public void setUserId(Integer userId) {
	this.userId = userId;
}


}