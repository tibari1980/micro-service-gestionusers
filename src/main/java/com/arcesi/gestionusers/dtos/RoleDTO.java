package com.arcesi.gestionusers.dtos;

import java.time.Instant;

import org.apache.commons.lang.StringUtils;

import com.arcesi.gestionusers.constants.IConstanteMessageErrors;
import com.arcesi.gestionusers.dtos.requestdto.RoleRequest;
import com.arcesi.gestionusers.dtos.responsedto.RoleResponse;
import com.arcesi.gestionusers.entities.RoleBean;
import com.arcesi.gestionusers.exceptions.InvalidEntityException;

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
	
	
	/**
	 * Méthode permettant de mapper un objet RoleDTO to RoleBean
	 * @param dto  {@link RoleDTO } 
	 * @return bean {@link RoleBean }
	 */
	public static RoleBean toEntity(RoleDTO dto) {
		if(dto==null) {
			throw new InvalidEntityException(IConstanteMessageErrors.ROLE_NOT_VALIDE.getIdMessage());
		}
		return  RoleBean.builder()
				.codeRole(dto.getCodeRole())
				.codeUniqueRole(dto.getCodeUniqueRole())
				.createdAt(dto.getCreatedAt())
				.updatedAd(dto.getUpdatedAd())
				.roleName(dto.getRoleName())
				.build();
	}
	
	
	/**
	 * Méthode permettant de mapper un objet RoleBean to RoleDTO
	 * @param bean  {@link RoleBean } 
	 * @return dto {@link RoleDTO }
	 */
	public static RoleDTO fromEntity(RoleBean bean) {
		if(bean==null) {
			throw new InvalidEntityException(IConstanteMessageErrors.ROLE_NOT_VALIDE.getIdMessage());
		}
		return  RoleDTO .builder()
				.codeRole(bean.getCodeRole())
				.codeUniqueRole(bean.getCodeUniqueRole())
				.createdAt(bean.getCreatedAt())
				.updatedAd(bean.getUpdatedAd())
				.roleName(bean.getRoleName())
				.build();
	}
	

	
	/**
	 * Méthode permettant de mapper un objet RoleBean to RoleDTO
	 * @param bean  {@link RoleBean } 
	 * @return dto {@link RoleDTO }
	 */
	public static RoleDTO RoleRequestToRoleDTO(RoleRequest request) {
		if(request==null) {
			throw new InvalidEntityException(IConstanteMessageErrors.ROLE_NOT_VALIDE.getIdMessage());
		}
		return  RoleDTO .builder()
				.roleName(StringUtils.isNotEmpty(request.getRoleName())? request.getRoleName().toUpperCase():null)
				.build();
	}
	
	
	/**
	 * Méthode permettant de mapper un objet RoleDTO to RoleResponse
	 * @param dto  {@link RoleDTO } 
	 * @return bean {@link RoleResponse }
	 */
	public static RoleResponse RoleDTOToRoleResponse(RoleDTO dto) {
		if(dto==null) {
			throw new InvalidEntityException(IConstanteMessageErrors.ROLE_NOT_VALIDE.getIdMessage());
		}
		return  RoleResponse.builder()
				.codeUniqueRole(dto.getCodeUniqueRole())
				.createdAt(dto.getCreatedAt())
				.updatedAd(dto.getUpdatedAd())
				.roleName(dto.getRoleName())
				.build();
	}
	
}
