package com.arcesi.gestionusers.controllers.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arcesi.gestionusers.controllers.IUserApiRest;
import com.arcesi.gestionusers.dtos.UserDTO;
import com.arcesi.gestionusers.dtos.requestdto.UserRequest;
import com.arcesi.gestionusers.dtos.responsedto.UserResponse;
import com.arcesi.gestionusers.services.IUserRestService;
import com.arcesi.gestionusers.utils.Constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@RestController
@Getter
@Setter
@Slf4j
@AllArgsConstructor
@RequestMapping(value = Constants.APP_ROOT + "/users")
public class UserRestApiController implements IUserApiRest {

	private IUserRestService iUserRestService;

	@Override
	public ResponseEntity<List<UserResponse>> findAllUser(int page, int limit) {

		log.info("Inside method findallUser in controllers UserRestApiController : page :{} size : {}", page, limit);
		List<UserDTO> userDtos = iUserRestService.findAllUsers(page, limit);
		List<UserResponse> userResponses = userDtos.stream().filter(a -> a != null).map(UserDTO::UserDTOToUserResponse)
				.collect(Collectors.toList());
		return new ResponseEntity<List<UserResponse>>(userResponses,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UserResponse> findOneByCodeUniqueClient(String codeUnique) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<UserResponse> findOneUserByName(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<UserResponse> findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<UserResponse> updateUser(UserRequest userRequest, Long code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> deleteUser(Long code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<UserResponse> createUser(UserRequest userRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
