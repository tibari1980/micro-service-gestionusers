package com.arcesi.gestionusers.dtos;

import java.io.Serializable;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
@Data
@ToString
@AllArgsConstructor
public class AbstractEntityDTO implements Serializable{

 
	private static final long serialVersionUID = 1L;
	private Instant createdAt;
	private Instant updatedAd;
	
}
