package com.Ecomercial.CTTT2018.auth;

import com.Ecomercial.CTTT2018.models.domain.User;
import com.Ecomercial.CTTT2018.models.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getUserByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(String.format("User with username=%s was not found", username)));
		return new CurrentUser(user);
	}
}
