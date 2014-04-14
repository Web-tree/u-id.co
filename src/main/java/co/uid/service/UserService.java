package co.uid.service;

import co.uid.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Maxim Levicky
 */
@Service
public class UserService implements UserDetailsService, AuthenticationManager {
    @Autowired
    private Neo4jOperations template;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getByUsername(username);
        if (null == user) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }
        return user;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        if (null == getByUsername(username)) {
            throw new AuthenticationCredentialsNotFoundException("User " + username + " not found");
        }
        authentication.setAuthenticated(true);
        return authentication;
    }

    public User getByUsername(String username) {
        return template.lookup(User.class, "username", username).to(User.class).single();
    }
}
