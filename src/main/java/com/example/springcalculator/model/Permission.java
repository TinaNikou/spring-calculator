package com.example.springcalculator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Permission {
	
	public Permission() {
	}
	
	public Permission(String roleName) {
		this.roleName = roleName;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int permissionId;
	
	@NotNull
	private String roleName;
	
	public int getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
