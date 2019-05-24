package com.aside.account;

import com.aside.dao.FileDao;
import com.aside.util.UserInfo;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.Resource;
import java.util.List;

public class CustomeAuthenticationProvider  implements AuthenticationProvider {

    @Resource
    CustomeUserDetailsService customeUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authToken = (UsernamePasswordAuthenticationToken) authentication;
        System.out.println("===================================================================");
        System.out.println(authToken);
        System.out.println("===================================================================");
        UserDetails userInfo = customeUserDetailsService.loadUserByUsername(authToken.getName());
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) userInfo.getAuthorities();

        System.out.println("===================================================================");
        System.out.println(userInfo.toString());
        System.out.println("===================================================================");

       /* return new UsernamePasswordAuthenticationToken(userInfo,null,authorities);*/
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
