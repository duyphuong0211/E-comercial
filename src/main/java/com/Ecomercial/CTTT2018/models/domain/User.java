package com.Ecomercial.CTTT2018.models.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "password_hash", nullable = false)
	private String passwordHash;

	@Column(name = "name", nullable = false, unique = false)
	private String name;

	@ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
	@JoinTable(name = "userRoles", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "roles", nullable = false)
	@Enumerated(EnumType.STRING)
	private Set<Role> roles;

	//TODO MAKE SET OF ROLES NOT COLLECITON
	@OneToMany(mappedBy = "user")
	private List<Order> orders;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private ShoppingCart shoppingCart;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private StoreOwner storeOwner;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Admin admin;

	public User(Long Id, String username, String email, String passwordHash, String name, Set<Role> roles) {
		this.id = Id;
		this.username = username;
		this.email = email;
		this.passwordHash = passwordHash;
		this.name = name;
		this.roles = roles;
	}
}