package com.arcesi.gestionusers.controllers;

import java.awt.print.Book;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.arcesi.gestionusers.dtos.requestdto.UserRequest;
import com.arcesi.gestionusers.dtos.responsedto.UserResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface IUserApiRest {

	@GetMapping(value = "/api/all", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Cette méthode permet de récupérer la liste des utilisateurs ")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "La liste des utilisateurs", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = UserResponse.class)) }),
			  @ApiResponse(responseCode = "404", description = "La liste est vide", 
			    content = @Content) })
	public ResponseEntity<List<UserResponse>> findAllUser(
			@RequestParam(name = "page", defaultValue = "0") final int page,
			@RequestParam(name = "limit", defaultValue = "10") final int limit);

	
	@Operation(summary = "Récuprer l'utilisateur par son code unique")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "L'utilisateur trouvé avec son code unique", 
	    content = { @Content(mediaType = "application/json", 
	      schema = @Schema(implementation = UserResponse.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalide", 
	    content = @Content), 
	  @ApiResponse(responseCode = "404", description = "L'utilisateur  n'exist pas avec le code unique", 
	    content = @Content) })
	@GetMapping(value = "/api/findByCodeUnique/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<UserResponse> findOneByCodeUniqueClient(@PathVariable(name = "code") String codeUnique);

	
	@GetMapping(value = "/api/findByName/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<UserResponse> findOneUserByName(@PathVariable(name = "nom") String nom);

	@GetMapping(value = "/api/findByEmail/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<UserResponse> findUserByEmail(@PathVariable(name = "email") String email);

	
	@PutMapping(value = "/api/{code}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest userRequest,
			@PathVariable(name = "code") Long code);

	
	@DeleteMapping(value = "/api/{code}")
	
	public ResponseEntity<Object> deleteUser(@PathVariable(name = "code") Long code);

	
	
	@PostMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest);

}
