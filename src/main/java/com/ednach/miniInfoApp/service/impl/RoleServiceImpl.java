package com.ednach.miniInfoApp.service.impl;

import com.ednach.miniInfoApp.model.Role;
import com.ednach.miniInfoApp.repository.RoleRepository;
import com.ednach.miniInfoApp.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findByRoleNome(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElseThrow(()->new RuntimeException());
    }

    @Override
    public Role save(Role role) {
        return roleRepository.saveAndFlush(role);
    }

    @Override
    public Role update(Role role) {
        final Long id = role.getId();
        findById(id);
        return roleRepository.saveAndFlush(role);
    }

    @Override
    public void delete(Role role) {
        Long id = role.getId();
        findById(id);
        roleRepository.delete(role);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        roleRepository.deleteById(id);
    }
}
