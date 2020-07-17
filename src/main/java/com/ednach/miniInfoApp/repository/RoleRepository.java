package com.ednach.miniInfoApp.repository;

import com.ednach.miniInfoApp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
     @Query("SELECT DISTINCT r from Role r join r.users")
    List<Role> findAll();

    Role findByRoleName(String roleName);
}
