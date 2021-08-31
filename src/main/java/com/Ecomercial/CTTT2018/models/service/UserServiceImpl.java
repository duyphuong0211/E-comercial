package com.Ecomercial.CTTT2018.models.service;

import com.Ecomercial.CTTT2018.forms.UserCreateForm;
import com.Ecomercial.CTTT2018.models.domain.Role;
import com.Ecomercial.CTTT2018.models.domain.User;
import com.Ecomercial.CTTT2018.models.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	//	@Autowired
//	public UserServiceImpl(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}

	@Override
	public Optional<User> getUserById(long id) {
		return Optional.empty();
	}

	@Override
	public Optional<User> getUserByEmail(String email) {
		return userRepository.findOneByEmail(email);
	}

	@Override
	public Optional<User> getUserByUsername(String email) {
		return userRepository.findOneByUsername(email);
	}

	@Override
	public Collection<User> getAllUsers() {
		return null;
	}


	@Override
	public User register(UserCreateForm form) {
		User user = new User();
		user.setName(form.getName());
		user.setUsername(form.getUsername());
		user.setEmail(form.getEmail());
		user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
		//Create Roles List
		Collection<Role> roles = new ArrayList<>();
		roles.add(Role.USER);
		//Add Roles List to User
		user.setRoles(roles);
		return userRepository.save(user);
	}
}
