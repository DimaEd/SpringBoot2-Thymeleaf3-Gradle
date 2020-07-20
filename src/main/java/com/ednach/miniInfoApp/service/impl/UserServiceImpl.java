package com.ednach.miniInfoApp.service.impl;

import com.ednach.miniInfoApp.model.User;
import com.ednach.miniInfoApp.repository.UserRepository;
import com.ednach.miniInfoApp.service.RoleService;
import com.ednach.miniInfoApp.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

  //  private final PasswordEncoder encoder;

    private RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User save(User user) {
        return saveAndFlush(user);
    }

    @Override
    public User update(User user) {
        final Long id = user.getId();
        findById(id);
        return saveAndFlush(user);
    }

    @Override
    public void delete(User user) {
        Long id = user.getId();
        findById(id);
        userRepository.delete(user);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        userRepository.deleteById(id);
    }

    private User saveAndFlush(User user) {
        user.getRoles().forEach(role -> {
            role.setRoleName(roleService.findById(role.getId()).getRoleName());
        });
     //   user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.saveAndFlush(user);
    }
}
