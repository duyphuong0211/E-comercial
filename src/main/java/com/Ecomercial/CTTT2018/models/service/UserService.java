package com.Ecomercial.CTTT2018.models.service;

import com.Ecomercial.CTTT2018.forms.UserCreateForm;
import com.Ecomercial.CTTT2018.models.domain.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

	Optional<User> getUserById(long id);

	Optional<User> getUserByEmail(String email);

	Optional<User> getUserByUsername(String email);

	Collection<User> getAllUsers();

	User register(UserCreateForm form);

}
