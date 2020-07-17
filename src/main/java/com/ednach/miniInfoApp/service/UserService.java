package com.ednach.miniInfoApp.service;

import com.ednach.miniInfoApp.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    User findByName(String name);

    User save(User user);

    User update(User user);

    void delete(User user);

    void deleteById(Long id);

}
