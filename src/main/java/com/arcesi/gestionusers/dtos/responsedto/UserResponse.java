package com.arcesi.gestionusers.dtos.responsedto;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 
 * @author ZEROUAL Tibari
 *ingénieur developpement
 */
@Getter @Setter @ToString
public class UserResponse extends AbstractResponseDTO{

	private static final long serialVersionUID = 1L;
	private String uidUser;
	private String firstName;
	private String lastName;
	private String email;
	private Set<RoleResponse> roleResponses = new HashSet<RoleResponse>();
	private Boolean locked;
	private Boolean enabled ;
	
	@Builder
	public UserResponse(Instant createdAt, Instant updatedAd, String uidUser, String firstName, String lastName,
			String email, Set<RoleResponse> roleResponses, Boolean locked, Boolean enabled) {
		super(createdAt, updatedAd);
		this.uidUser = uidUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleResponses = roleResponses;
		this.locked = locked;
		this.enabled = enabled;
	}
	
	
	
	
	
	
}
