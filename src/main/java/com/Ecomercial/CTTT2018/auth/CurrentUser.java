package com.Ecomercial.CTTT2018.auth;

import antlr.StringUtils;
import com.Ecomercial.CTTT2018.models.domain.Role;
import com.Ecomercial.CTTT2018.models.domain.User;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

	private User user;

	public CurrentUser(User user) {
		super(user.getUsername(), user.getPasswordHash(),
				AuthorityUtils.commaSeparatedStringToAuthorityList(
						StringUtils.stripFrontBack(user.getRoles().toString(), "[", "]" )
				)
		);
		this.user = user;
	}

	public User getUser() {
		return user;
	}
	public long getId() {
		return user.getId();
	}

	public Collection<Role> getRole() {
		return user.getRoles();
	}

}
