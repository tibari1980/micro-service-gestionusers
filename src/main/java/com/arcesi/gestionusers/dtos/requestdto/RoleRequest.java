package com.arcesi.gestionusers.dtos.requestdto;

import java.time.Instant;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * v1
 * @author ZEROUAL Tibari
 * Ingénieur developpement
 *
 */
@Getter @Setter @ToString
public class RoleRequest  extends AbstractRequestDTO{

	
	private static final long serialVersionUID = 1L;
	/** nom duc role **/
	private String roleName;
	
	@Builder
	public RoleRequest(Instant createdAt, Instant updatedAd, String roleName) {
		super(createdAt, updatedAd);
		this.roleName = roleName;
	}
	
	
	
}
