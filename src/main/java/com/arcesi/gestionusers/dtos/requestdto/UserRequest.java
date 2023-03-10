package com.arcesi.gestionusers.dtos.requestdto;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRequest extends AbstractRequestDTO {

	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String email;
	private Set<RoleRequest> roleRequests = new HashSet<RoleRequest>();

	@Builder
	public UserRequest(Instant createdAt, Instant updatedAd, String firstName, String lastName, String email,
			Set<RoleRequest> roleRequests) {
		super(createdAt, updatedAd);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleRequests = roleRequests;
	}

}
