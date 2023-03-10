package com.arcesi.gestionusers.services.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arcesi.gestionusers.dtos.UserDTO;
import com.arcesi.gestionusers.entities.UserBean;
import com.arcesi.gestionusers.enumerations.ErrorsCodesEnemuration;
import com.arcesi.gestionusers.exceptions.EntityNotFoundException;
import com.arcesi.gestionusers.repositories.RoleRepository;
import com.arcesi.gestionusers.repositories.UserRepository;
import com.arcesi.gestionusers.services.IUserRestService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@AllArgsConstructor
@Slf4j
@Service
@Transactional

public class UserRestServiceImp implements IUserRestService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;

	@Override
	public UserDTO addUser(UserDTO user) {

		return null;
	}

	@Override
	public List<UserDTO> findAllUsers(int page, int limit) {
		if (page > 0) {
			page = page - 1;
		}
		Pageable pageable = PageRequest.of(page, limit, Sort.by("id").descending());
		Page<UserBean> pageUserBean = userRepository.findAll(pageable);

		List<UserBean> listeUserBeans = pageUserBean.getContent();
		if (listeUserBeans.isEmpty()) {
			log.error("List of clients is empty :{}", listeUserBeans);
			throw new EntityNotFoundException("aucun users trouvés dans notre base de données",
					ErrorsCodesEnemuration.USER_NOT_FOUND);
		}
		List<UserDTO> usersDtos = listeUserBeans.stream().map(UserDTO::fromBean).collect(Collectors.toList());
		return usersDtos;
	}

}
