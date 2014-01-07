package com.yodes.excel.web.security;

import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Class to represent a user stored as a document in a mongodb
 */
@Document
public class MongoUser implements UserDetails {

	public MongoUser(String username, String password, Collection<GrantedAuthority> authorities) {
		this.setUsername(username);
		this.setPassword(password);
		this.setAuthorities(authorities);
	}

	/**
	 * Version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Unique ID of the user
	 */
	@Id
	private String id;

	/**
	 * Users name
	 */
	private String username;

	/**
	 * Users password
	 */
	private String password;

	/**
	 * Collection of users {@link GrantedAuthority}
	 */
	private Collection<GrantedAuthority> authorities;

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

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the authorities
	 */
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	/**
	 * @param authorities
	 *            the authorities to set
	 */
	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
}
