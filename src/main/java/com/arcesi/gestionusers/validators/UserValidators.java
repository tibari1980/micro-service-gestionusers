package com.arcesi.gestionusers.validators;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.arcesi.gestionusers.constants.IConstanteMessageErrors;
import com.arcesi.gestionusers.dtos.UserDTO;
import com.arcesi.gestionusers.exceptions.CannotBeNullException;
import com.arcesi.gestionusers.utils.ControleSyntaxe;
import com.arcesi.gestionusers.utils.Utils;

/**
 * 
 * @author Zeroual tibari ingénieur de developpement
 */
//Class permettant de valider les champs obligatoire de l'entité user
public class UserValidators {

	public static List<String> validate(final UserDTO dto) throws CannotBeNullException {
		final List<String> errors = new ArrayList<String>();
		if (dto == null) {
			errors.add(IConstanteMessageErrors.USER_NOT_VALIDE.getIdMessage());
		}
		if (dto != null) {
			// vériffier le champ nom
			if (StringUtils.isEmpty(dto.getFirstName())) {
				errors.add(IConstanteMessageErrors.USER_NOM_OBLIGATOIRE.getIdMessage());
			} else if (StringUtils.isNotBlank(dto.getFirstName())
					&& (dto.getFirstName().length() < 5 || dto.getFirstName().length() > 40)) {
				errors.add(IConstanteMessageErrors.USER_NOM_TAIL_NOT_VALID.getIdMessage());
			} else if (Utils.isBooleanFalse(ControleSyntaxe.isAlphanumerique(dto.getFirstName()))) {
				errors.add(IConstanteMessageErrors.USER_NOM_ALPHA.getIdMessage());
			}

			// vériffier le champ Prenom
			if (StringUtils.isEmpty(dto.getLastName())) {
				errors.add(IConstanteMessageErrors.USER_PRENOM_OBLIGATOIRE.getIdMessage());
			} else if (StringUtils.isNotBlank(dto.getLastName())
					&& (dto.getLastName().length() < 5 || dto.getLastName().length() > 40)) {
				errors.add(IConstanteMessageErrors.USER_PRENOM_TAIL_NOT_VALID.getIdMessage());
			} else if (Utils.isBooleanFalse(ControleSyntaxe.isAlphanumerique(dto.getLastName()))) {
				errors.add(IConstanteMessageErrors.USER_PRENOM_ALPHA.getIdMessage());
			}

			// Vérification email
			// Vérification Email
			if (StringUtils.isEmpty(dto.getEmail())) {
				errors.add(IConstanteMessageErrors.USER_EMAIL.getIdMessage());
			} else if (StringUtils.isNotBlank(dto.getEmail())) {
				if (dto.getEmail().length() < 15) {
					errors.add(IConstanteMessageErrors.USER_EMAIL_SIZE_MIN.getIdMessage());
				} else if (dto.getEmail().length() >= 100) {
					errors.add(IConstanteMessageErrors.USER_EMAIL_SIZE_MAX.getIdMessage());
				} else if (Utils.isBooleanFalse(ControleSyntaxe.isEmailValide(dto.getEmail()))) {
					errors.add(IConstanteMessageErrors.USER_EMAIL_ALPHA.getIdMessage());
				}
			}

		}
		return errors;
	}
}
