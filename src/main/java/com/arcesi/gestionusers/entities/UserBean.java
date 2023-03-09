package com.arcesi.gestionusers.entities;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "USERS", uniqueConstraints = { @UniqueConstraint(columnNames = "email", name = "user_email_unique"),
		@UniqueConstraint(columnNames = "CLE_UNIQUE_USER", name = "user_uidUser_unique") })

public class UserBean extends AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SequenceGenerator(name = "appuser_sequence", allocationSize = 1, sequenceName = "appuse_sequence")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appuser_sequence")
	@Column(name = "CODE_USER", unique = true)
	private Long id;
	@Column(name = "CLE_UNIQUE_USER", updatable = false, unique = true, insertable = true)
	private String uidUser;
	@Column(name = "FIRST_NAME", updatable = true, columnDefinition = "TEXT")
	private String firstName;
	@Column(name = "LAST_NAME", updatable = true, columnDefinition = "TEXT")
	private String lastName;
	@Column(name = "EMAIL", unique = true)
	private String email;
	@Column(name = "PASSWORD", length = 255)
	private String password;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "CODE_ROLE"))
	private Collection<RoleBean> roleBeans = new ArrayList<RoleBean>();
	@Column(name = "LOCKED")
	private Boolean locked = Boolean.FALSE;
	@Column(name = "ENABLED")
	private Boolean enabled = Boolean.FALSE;

	@Column(name = "IP_ADRESSE_USER", insertable = true)
	private String ipAdresse;

	@Column(name = "TELEPHONE")
	private String telephoneClient;
	@Column(name = "PHOTO")
	private String photoClient;
	@Column(name = "DATE_NAISSANCE", nullable = false, insertable = true, updatable = true)
	private LocalDate dateNaissanceClient;
	@Column(name = "AGE")
	private Integer ageClient;
	@Column(name = "PAYS_NAISSANCE", insertable = true, updatable = true, nullable = false)
	private String paysNaissance;
	@Column(name = "VILLE_NAISSANCE", insertable = true, updatable = true, nullable = false)
	private String villeNaissance;
	@Column(name = "DEPARTEMENT_NAISSANCE", length = 3)
	private String departementNaissance;
	@Column(name = "RAISON_SOCIAL", length = 60)
	private String raisonSocial;
	@Column(name = "SIRET", length = 50)
	private String numeroSiret;

	@Builder
	public UserBean(Instant createdAt, Instant updatedAd, Long id, String uidUser, String firstName, String lastName,
			String email, String password, Collection<RoleBean> roleBeans, Boolean locked, Boolean enabled,
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
		this.roleBeans = new ArrayList<RoleBean>();
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
