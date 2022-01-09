/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.security.service;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.security.entity.User;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.security.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author daniel
 */
@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;
    
    public Optional<User> getByUserName(String userName){
        return userRepository.findByUserName(userName);
    }
    
    public boolean existsByUserName(String userName){
        return userRepository.existsByUserName(userName);
    }
    
    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }
    
    public void save(User user){
        userRepository.save(user);
    }
}
