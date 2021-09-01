package com.Ecomercial.CTTT2018.utilities;

import com.Ecomercial.CTTT2018.auth.CurrentUser;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtil {
    //Only use it in non controller context!
    public static CurrentUser getCurrentUser(){
        return (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
