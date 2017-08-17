package com.travellerApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.travellerApp.dao.UserDao1;
import com.travellerApp.entities.User;

@Component
public class OAuthUserService implements UserDetailsService {
	
	@Autowired
	UserDao1 userRepository;
	
	 @Override
	    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
	        User user = userRepository.findByUserName(s);

	        if(user == null) {
	            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", s));
	        }
	        List<GrantedAuthority> authorities = new ArrayList<>();
	        user.getRoles().forEach(role -> {
	            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
	        });
	        UserDetails userDetails = new org.springframework.security.core.userdetails.
	                User(user.getUserName(), user.getPassword(),authorities);

	        return userDetails;
	    }

}
