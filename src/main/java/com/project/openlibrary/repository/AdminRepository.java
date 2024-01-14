package com.project.openlibrary.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.openlibrary.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String>{
	
    Admin findByUsername(String username);

}