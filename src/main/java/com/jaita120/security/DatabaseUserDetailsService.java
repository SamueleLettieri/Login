package com.jaita120.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jaita120.model.User;
import com.jaita120.reporitory.UserRepository;

public class DatabaseUserDetailsService implements UserDetailsService{

	
	private @Autowired UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Optional<User> optionalUser = userRepository.findByUsername(username);
	        if (!optionalUser.isPresent()) {
	            throw new UsernameNotFoundException("User not found");
	        }
	        User user = optionalUser.get();
	        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
	    
	}
	
    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        return Arrays.asList(new SimpleGrantedAuthority("USER"));
    }
}
