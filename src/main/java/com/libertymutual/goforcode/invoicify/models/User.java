package com.libertymutual.goforcode.invoicify.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "invoicify_user")
public class User implements UserDetails {

	public List<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false, unique = true)
	private String username;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
	private List<UserRole> roles;

	public User() {
	}

	public User(String username, String password, String roleName) {
		this.username = username;
		this.password = password;

		roles = new ArrayList<UserRole>();
		roles.add(new UserRole(roleName, this));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// List<String> roleNames = new ArrayList<String>();
		// for (UserRole role : roles) {
		// roleNames.add("ROLE_" + role.getName());
		// }

		List<String> roleNames = roles.stream().map(userRole -> "ROLE_" + userRole.getName())
				.collect(Collectors.toList());

		String authorityString = String.join(",", roleNames);
		return AuthorityUtils.commaSeparatedStringToAuthorityList(authorityString);

	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	// getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
