package com.glearning.LabSixDebateEvent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.glearning.LabSixDebateEvent.dao.UserRepository;
import com.glearning.LabSixDebateEvent.model.Users;
import com.glearning.LabSixDebateEvent.security.MyUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users users = userRepository.getUserByUsername(username);

		if (users == null) {
			throw new UsernameNotFoundException("Could not find user");
		}

		return new MyUserDetails(users);
	}

}
