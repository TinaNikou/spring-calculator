package com.example.springcalculator.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class User implements UserDetails {
	@Id
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // Lazy vs. Eager. Users will need permissions all the time - so make this eager
	private List<Permission> permissions;
	
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

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> perms = new LinkedList<GrantedAuthority>();
		for (Permission p : permissions) {
			perms.add(new SimpleGrantedAuthority("ROLE_" + p.getRoleName()));
		}
		return perms;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true; // Our accounts won't expire
	}

	@Override
	public boolean isAccountNonLocked() {
		return true; // Accounts won't lock
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true; // dOn't expire
	}

	@Override
	public boolean isEnabled() {
		return true; // always enabled
	}
}
