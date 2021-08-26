package com.Ecomercial.CTTT2018.auth;


public interface CurrentUserService {

	boolean canAccessUser(CurrentUser currentUser, int userId);

}
