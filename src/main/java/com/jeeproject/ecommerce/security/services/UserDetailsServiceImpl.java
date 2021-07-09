package com.jeeproject.ecommerce.security.services;

import com.jeeproject.ecommerce.model.User;
import com.jeeproject.ecommerce.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepo userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        User user = null;
        try {
            user = (User) userRepository.findByEmail(email)
                    .orElseThrow(() ->
                            new UsernameNotFoundException("User Not Found with -> email : " + email)
                    );
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return UserPrinciple.build(user);
    }
}
