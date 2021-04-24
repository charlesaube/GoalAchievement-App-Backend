package com.example.projet_web.security;

import com.example.projet_web.Model.entities.UserAuth;
import com.example.projet_web.repositories.interfaces.UserAuthRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private final UserAuthRepository userAuthRepository;

    public UserPrincipalDetailsService(UserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserAuth userAuth = this.userAuthRepository.findOneByUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException("User login not found"));
        return new UserPrincipal(userAuth);

    }
}
