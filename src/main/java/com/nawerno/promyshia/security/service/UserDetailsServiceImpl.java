package com.nawerno.promyshia.security.service;

import com.nawerno.promyshia.entity.User;
import com.nawerno.promyshia.repository.read.UserReadRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    final private UserReadRepository userReadRepository;

    public UserDetailsServiceImpl(UserReadRepository userReadRepository) {
        this.userReadRepository = userReadRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userReadRepository.getByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + email));

        return UserDetailsImpl.build(user);
    }

}
