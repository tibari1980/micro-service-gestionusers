package com.arcesi.gestionusers.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arcesi.gestionusers.dtos.responsedto.UserResponse;

public interface IUserApiRest {

	@GetMapping(value = "/api/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserResponse>> findAllUser(
			@RequestParam(name = "page", defaultValue = "0") final int page,
			@RequestParam(name = "limit", defaultValue = "10") final int limit);
}
