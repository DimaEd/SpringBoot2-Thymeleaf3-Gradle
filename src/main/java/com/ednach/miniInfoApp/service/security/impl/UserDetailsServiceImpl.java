package com.ednach.miniInfoApp.service.security.impl;
//
//import com.ednach.miniInfoApp.model.User;
//import com.ednach.miniInfoApp.security.model.AuthenticationUserDetails;
//import com.ednach.miniInfoApp.service.UserService;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Service
//@Transactional
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    private final UserService userService;
//
// //   public UserDetailsServiceImpl(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        final User user = userService.findByName(username);
//        final Set<SimpleGrantedAuthority> authorities = user.getRoles().stream()
//                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
//                .collect(Collectors.toSet());
//        return new AuthenticationUserDetails(user.getId(), user.getName(), user.getPassword(), authorities);
//    }
//}