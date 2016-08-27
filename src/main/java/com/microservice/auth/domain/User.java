
//Namespace
package com.microservice.auth.domain;

//Imports


import javax.persistence.*;

/**
 * Class that represents user entity
 */
@Entity
@Table(name = "gnb_user")
public class User {

    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	private String username;
	private String email;
	private String password;
    private String role;
    private boolean active;
    private boolean passwordReset;



	/**
	 * Default constructor
	 */
	public User(){}


    /**
     * Constructor user for UserDetailService
     * @param user
     */
    public User(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.role = user.getRole();
        this.active = user.isActive();
        this.passwordReset = user.isPasswordReset();
    }


	//Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isPasswordReset() {
        return passwordReset;
    }

    public void setPasswordReset(boolean passwordReset) {
        this.passwordReset = passwordReset;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}



