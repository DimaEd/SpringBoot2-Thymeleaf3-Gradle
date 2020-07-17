package com.ednach.miniInfoApp.service;

import com.ednach.miniInfoApp.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    Role findById (Long id);

    Role findByRoleNome(String roleName);

    Role save(Role role);

    Role update(Role role);

    void delete(Role role);

    void deleteById(Long id);

}
