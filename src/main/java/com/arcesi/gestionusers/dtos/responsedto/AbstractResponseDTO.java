package com.arcesi.gestionusers.dtos.responsedto;

import java.io.Serializable;
import java.time.Instant;

import lombok.Data;
/**
 * 
 * @author zeroual tibari
 *ingénieur developpement
 */
@Data
public class AbstractResponseDTO implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Instant createdAt;
	private Instant updatedAd;
	
	public AbstractResponseDTO(Instant createdAt, Instant updatedAd) {
		super();
		this.createdAt = createdAt;
		this.updatedAd = updatedAd;
	}
	
	
}
