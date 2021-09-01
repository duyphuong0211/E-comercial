package com.Ecomercial.CTTT2018.utilities;

import com.Ecomercial.CTTT2018.auth.CurrentUser;
import com.Ecomercial.CTTT2018.models.domain.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import java.util.ArrayList;
import java.util.List;

public class AuthUtil {
    //Only use it in non controller context!
    public static CurrentUser getCurrentUser(){
        return (CurrentUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static void addRoleAtRuntime(Role role){
        //Add Role at Runtime!
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<GrantedAuthority> updatedAuthorities = new ArrayList<>(auth.getAuthorities());

        if(updatedAuthorities.contains(new SimpleGrantedAuthority(role.name())))
            return;

        //Add it in List
        updatedAuthorities.add(new SimpleGrantedAuthority(role.name()));

        //Add it in Session User
        CurrentUser updatedUser = getCurrentUser();
        updatedUser.getRole().add(role);

        //Update
        Authentication newAuth = new PreAuthenticatedAuthenticationToken(updatedUser, auth.getCredentials(), updatedAuthorities);
        SecurityContextHolder.getContext().setAuthentication(newAuth);
    }
}
