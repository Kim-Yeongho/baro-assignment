package com.baro.baro_assignment.auth.infrastructure;

import com.baro.baro_assignment.auth.model.User;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final List<User> users;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.stream().filter(user1 -> user1.getUsername().equals(username)).findFirst().orElse(null);
        return new UserDetailsImpl(user);
    }
}
