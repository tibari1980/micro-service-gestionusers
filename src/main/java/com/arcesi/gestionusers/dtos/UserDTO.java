package com.arcesi.gestionusers.dtos;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.arcesi.gestionusers.constants.IConstanteMessageErrors;
import com.arcesi.gestionusers.dtos.requestdto.UserRequest;
import com.arcesi.gestionusers.dtos.responsedto.UserResponse;
import com.arcesi.gestionusers.entities.UserBean;
import com.arcesi.gestionusers.exceptions.InvalidEntityException;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author zeroual tibari ingénieur fullstack
 */
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
	private Set<RoleDTO> roleDTOs = new HashSet<RoleDTO>();
	private Boolean locked = Boolean.FALSE;
	private Boolean enabled = Boolean.FALSE;

	private String ipAdresse;

	@Builder
	public UserDTO(Instant createdAt, Instant updatedAd, Long id, String uidUser, String firstName, String lastName,
			String email, String password, Set<RoleDTO> roleDTOs, Boolean locked, Boolean enabled, String ipAdresse) {
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
	}

	/**
	 * Méthode permettant de mapper un UserDto vers UserBean
	 * 
	 * @param dto {@link UserDTO }
	 * @return bean {@link UserBean}
	 */
	public static UserBean toEntity(UserDTO dto) {
		if (dto == null) {
			throw new InvalidEntityException(IConstanteMessageErrors.USER_NOT_VALIDE.getIdMessage());
		}
		return UserBean.builder().id(dto.getId()).uidUser(dto.getUidUser()).createdAt(dto.getCreatedAt())
				.updatedAd(dto.getUpdatedAd()).firstName(dto.getFirstName()).lastName(dto.getLastName())
				.password(dto.getPassword()).email(dto.getEmail()).locked(dto.getLocked())

				.enabled(dto.getEnabled())
				.roleBeans(CollectionUtils.isNotEmpty(dto.getRoleDTOs())
						? dto.getRoleDTOs().stream().map(RoleDTO::toEntity).collect(Collectors.toSet())
						: null)
				.build();

	}

	/**
	 * Méthode permettant de mapper un objet UserBean to UserDto
	 * 
	 * @param bean {@link UserBean}
	 * @return dto {@link UserDTO}
	 */
	public static UserDTO fromBean(UserBean bean) {
		if (bean == null) {
			throw new InvalidEntityException(IConstanteMessageErrors.USER_NOT_VALIDE.getIdMessage());
		}
		return UserDTO.builder().id(bean.getId()).uidUser(bean.getUidUser()).createdAt(bean.getCreatedAt())
				.updatedAd(bean.getUpdatedAd()).lastName(bean.getLastName()).firstName(bean.getFirstName())
				.email(bean.getEmail()).enabled(bean.getEnabled()).locked(bean.getLocked())
				.roleDTOs(CollectionUtils.isNotEmpty(bean.getRoleBeans())
						? bean.getRoleBeans().stream().map(RoleDTO::fromEntity).collect(Collectors.toSet())
						: null)
				.build();

	}

	/**
	 * Méthode permettant de mapper un objet UserRequest to UserDto
	 * 
	 * @param request {@link UserRequest}
	 * @return dto {@link UserDTO}
	 */
	public static UserDTO UserRequestToUserDTO(UserRequest request) {
		if (request == null) {
			throw new InvalidEntityException(IConstanteMessageErrors.USER_NOT_VALIDE.getIdMessage());
		}
		return UserDTO.builder()
				.lastName(StringUtils.isNotEmpty(request.getLastName()) ? request.getLastName().trim().toUpperCase()
						: null)
				.firstName(StringUtils.isNotEmpty(request.getFirstName()) ? request.getFirstName().trim().toUpperCase()
						: null)
				.email(StringUtils.isNotEmpty(request.getEmail()) ? request.getEmail().trim() : null)
				.roleDTOs(CollectionUtils.isNotEmpty(request.getRoleRequests()) ? request.getRoleRequests().stream()
						.map(RoleDTO::RoleRequestToRoleDTO).collect(Collectors.toSet()) : null)
				.build();

	}
	
	/**
	 * Méthode permettant de mapper un UserDto vers UserResponse
	 * 
	 * @param dto {@link UserDTO }
	 * @return bean {@link UserBean}
	 */
	public static UserResponse UserDTOToUserResponse(UserDTO dto) {
		if (dto == null) {
			throw new InvalidEntityException(IConstanteMessageErrors.USER_NOT_VALIDE.getIdMessage());
		}
		return UserResponse.builder()
				.uidUser(dto.getUidUser())
				.createdAt(dto.getCreatedAt())
				.updatedAd(dto.getUpdatedAd())
				.firstName(dto.getFirstName())
				.lastName(dto.getLastName())
				.email(dto.getEmail())

				.roleResponses (
						CollectionUtils.isNotEmpty(dto.getRoleDTOs())
						? dto.getRoleDTOs().stream().map(RoleDTO::RoleDTOToRoleResponse).collect(Collectors.toSet())
						: null)
				.build();

	}
}
