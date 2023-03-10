package com.arcesi.gestionusers.entities;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

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
	private Set<RoleBean> roleBeans = new HashSet<RoleBean>();
	@Column(name = "LOCKED")
	private Boolean locked = Boolean.FALSE;
	@Column(name = "ENABLED")
	private Boolean enabled = Boolean.FALSE;

	@Column(name = "IP_ADRESSE_USER", insertable = true)
	private String ipAdresse;

	@Builder
	public UserBean(Instant createdAt, Instant updatedAd, Long id, String uidUser, String firstName, String lastName,
			String email, String password, Set<RoleBean> roleBeans, Boolean locked, Boolean enabled, String ipAdresse) {
		super(createdAt, updatedAd);
		this.id = id;
		this.uidUser = uidUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.roleBeans = new HashSet<RoleBean>();
		this.locked = locked;
		this.enabled = enabled;
		this.ipAdresse = ipAdresse;
	}

}
