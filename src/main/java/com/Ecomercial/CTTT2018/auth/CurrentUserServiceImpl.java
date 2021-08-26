package com.Ecomercial.CTTT2018.auth;

import com.Ecomercial.CTTT2018.models.domain.Role;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserServiceImpl implements CurrentUserService {

	@Override
	public boolean canAccessUser(CurrentUser currentUser, int userId) {
		return currentUser != null
				&& (currentUser.getRole() == Role.ADMIN || currentUser.getId() == userId);
	}

}
