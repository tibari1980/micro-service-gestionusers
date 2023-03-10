package com.arcesi.gestionusers.dtos.requestdto;

import java.io.Serializable;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @author ZEROUAL TIBARI ingénieur developpement
 *
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class AbstractRequestDTO  implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Instant createdAt;
	private Instant updatedAd;

}
