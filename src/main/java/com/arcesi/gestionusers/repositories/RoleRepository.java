package com.arcesi.gestionusers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arcesi.gestionusers.entities.RoleBean;

@Repository
public interface RoleRepository extends JpaRepository<RoleBean, Long> {

}
