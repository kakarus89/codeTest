package com.aside.account;

import com.aside.util.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomeUserDetailsService implements UserDetailsService {

    public GrantedAuthority getSecurityRole(String role) {
        return new SimpleGrantedAuthority(role);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("username : " + username);


        UserInfo t = new UserInfo();
        t.setUsername("aaa");
        t.setName("aaa");
        t.setPassword("1234");

        List<String> roleList = new ArrayList<String>();
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        Map<String, String> roleMap = new HashMap<String, String>();

        roleList.add("ROLE_USER");

        for (String role : roleList) {
            authorities.add(this.getSecurityRole(role));
            roleMap.put(role, role);
        }

        t.setAuthorities(authorities);
        t.setRoleList(roleList);
        t.setRoleMap(roleMap);


        System.out.println(t.toString());

        return t;
    }
}
