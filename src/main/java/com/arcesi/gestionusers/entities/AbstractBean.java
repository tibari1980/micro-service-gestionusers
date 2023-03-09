package com.arcesi.gestionusers.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@CreatedDate
	@Column(name="DATE_CREATION",nullable = false,insertable = true,updatable = false)
	private Instant createdAt;
	@LastModifiedDate
	@Column(name="DATE_MODIFICATION",insertable = true,updatable = true,nullable = true)
	private Instant updatedAd;
}
