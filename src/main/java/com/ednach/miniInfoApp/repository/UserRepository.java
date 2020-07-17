package com.ednach.miniInfoApp.repository;

import com.ednach.miniInfoApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * UserRepository provides the necessary search operations
 */
public interface UserRepository extends JpaRepository<User, Long> {
  //  @Query("SELECT DISTINCT u FROM User u JOIN FETCH u.role WHERE u.id=:id ORDER BY u.id")
    Optional<User> findById(Long id);

 //   @Query("SELECT DISTINCT u FROM User u JOIN FETCH u.role ORDER BY u.id")
    List<User> findAll();
//    @Query("SELECT DISTINCT u FROM User u JOIN FETCH u.role ORDER BY u.id")
//    List<User> findAllWithRoles();

    User findByName(String name);


    
}
