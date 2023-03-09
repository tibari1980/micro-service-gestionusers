package com.arcesi.gestionusers.dtos;

import java.time.Instant;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoleDTO extends AbstractEntityDTO {

	private static final long serialVersionUID = 1L;
	private Long codeRole;
	private String codeUniqueRole;
	private String roleName;
	
	@Builder
	public RoleDTO(Instant createdAt, Instant updatedAd, Long codeRole, String codeUniqueRole, String roleName) {
		super(createdAt, updatedAd);
		this.codeRole = codeRole;
		this.codeUniqueRole = codeUniqueRole;
		this.roleName = roleName;
	}
	
	

}
