package com.arcesi.gestionusers.constants;

public enum IConstanteMessageErrors {

	ROLE_NOT_VALIDE("Veuillez saisir tous les champs"), USER_NOT_VALIDE("Veuillez saisir tous les champs"),
	USER_NOM_OBLIGATOIRE("Veuillez saisir le nom "),
	USER_NOM_TAIL_NOT_VALID("nom doit être supérieur à 5 caractèrs et inférieur à 40 caractères"),
	USER_NOM_ALPHA("Le nom du user doit être alphanumérique !"),

	USER_PRENOM_OBLIGATOIRE("Veuillez saisir le prénom "),
	USER_PRENOM_TAIL_NOT_VALID("nom doit être supérieur à 5 caractèrs et inférieur à 40 caractères"),
	USER_PRENOM_ALPHA("Le prénom du user doit être alphanumérique !"),

	USER_EMAIL("Email ne peut pas être vide"), USER_EMAIL_SIZE_MIN("Email doit contenir au moins 15 caractères ."),
	USER_EMAIL_SIZE_MAX("Email ne doit pas dépassser  100 caractères ."), USER_EMAIL_ALPHA("Adresse email non valid!");

	public final String idMessage;

	private IConstanteMessageErrors(String idMessage) {
		this.idMessage = idMessage;
	}

	public String getIdMessage() {
		return idMessage;
	}

}
