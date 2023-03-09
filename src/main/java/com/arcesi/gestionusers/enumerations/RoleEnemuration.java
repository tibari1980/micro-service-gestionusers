package com.arcesi.gestionusers.enumerations;

public enum RoleEnemuration {
	EMP("EMPLOYER"), CLT("CLIENT"), ADMIN("ADMINISTRATEUR");

	public final String label;

	private RoleEnemuration(String label) {
		this.label=label;
	}

	public String getLabel() {
		return label;
	}

	
}
