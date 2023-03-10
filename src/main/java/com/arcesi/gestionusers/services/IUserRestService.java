package com.arcesi.gestionusers.services;

import java.util.List;

import com.arcesi.gestionusers.dtos.UserDTO;

public interface IUserRestService {

	/**
	 * 
	 * @param user {@link UserDTO }
	 * @return userDto en cas d'enregistrement
	 */
	public UserDTO addUser(UserDTO user);
	
	public List<UserDTO> findAllUsers(final int page,final int limit);
}
