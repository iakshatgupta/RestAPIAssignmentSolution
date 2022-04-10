package com.greatlearning.employeemanagementsystems.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.employeemanagementsystems.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
