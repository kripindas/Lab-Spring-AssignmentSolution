package com.greatlearning.service;

import com.greatlearning.entity.User;
import com.greatlearning.repository.UserRepository;
import com.greatlearning.security.MyUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		System.out.println("username:" + user.getUsername() +" ----- "+ "password: " + user.getPassword());
		return new MyUserDetails(user);
	}

}
