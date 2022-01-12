/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.security.service;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.security.entity.PrincipalUser;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author daniel
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService UserService;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = UserService.getByUserNameOrEmail(usernameOrEmail).get();
        return PrincipalUser.build(user);
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
    }

}
