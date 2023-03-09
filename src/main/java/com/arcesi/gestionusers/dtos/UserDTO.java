package com.arcesi.gestionusers.dtos;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO extends AbstractEntityDTO {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String uidUser;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Collection<RoleDTO> roleDTOs = new ArrayList<RoleDTO>();
	private Boolean locked = Boolean.FALSE;
	private Boolean enabled = Boolean.FALSE;

	private String ipAdresse;

	private String telephoneClient;
	private String photoClient;
	private LocalDate dateNaissanceClient;
	private Integer ageClient;
	private String paysNaissance;
	private String villeNaissance;
	@Column(name = "DEPARTEMENT_NAISSANCE", length = 3)
	private String departementNaissance;
	private String raisonSocial;
	private String numeroSiret;

	@Builder
	public UserDTO(Instant createdAt, Instant updatedAd, Long id, String uidUser, String firstName, String lastName,
			String email, String password, Collection<RoleDTO> roleDTOs, Boolean locked, Boolean enabled,
			String ipAdresse, String telephoneClient, String photoClient, LocalDate dateNaissanceClient,
			Integer ageClient, String paysNaissance, String villeNaissance, String departementNaissance,
			String raisonSocial, String numeroSiret) {
		super(createdAt, updatedAd);
		this.id = id;
		this.uidUser = uidUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.roleDTOs = roleDTOs;
		this.locked = locked;
		this.enabled = enabled;
		this.ipAdresse = ipAdresse;
		this.telephoneClient = telephoneClient;
		this.photoClient = photoClient;
		this.dateNaissanceClient = dateNaissanceClient;
		this.ageClient = ageClient;
		this.paysNaissance = paysNaissance;
		this.villeNaissance = villeNaissance;
		this.departementNaissance = departementNaissance;
		this.raisonSocial = raisonSocial;
		this.numeroSiret = numeroSiret;
	}

}
