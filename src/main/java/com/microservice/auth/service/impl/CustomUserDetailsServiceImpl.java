
//Namespace
package com.microservice.auth.service.impl;

//Imports

import com.microservice.auth.domain.User;
import com.microservice.auth.exception.DatabaseException;
import com.microservice.auth.exception.ResourceNotFoundException;
import com.microservice.auth.exception.UserNotActiveException;
import com.microservice.auth.repository.UserRepository;
import com.microservice.auth.service.CustomUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Customize class for UserDetailsService
 */
@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    //The LOG
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsServiceImpl.class);

    //Fields
	@Resource
    private UserRepository userRepository;

    /**
     * Retrieve user by username given
     * @param username
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String username)  {
        try {
            LOGGER.info("Retrieve user details from username [{}]", username);

            User user;
            if(username.contains("@")) {
                user = userRepository.findByEmail(username);
            }
            else {
                user = userRepository.findByUsername(username);
            }

            if (user == null) {
                LOGGER.warn("User with username [{}] was not found in the database", username);
                throw new ResourceNotFoundException("User not found");
            } else if (!user.isActive()) {
                LOGGER.warn("User with username [{}] is not active", username);
                throw new UserNotActiveException("User is not active");
            }

            return new UserRepositoryUserDetails(user);
        }
        catch (Exception e) {
            LOGGER.error("Unknown exception while searching for user: [{}]", username, e);
            throw new DatabaseException("Unknown exception while searching user by username", e);
        }
    }


    /**
     * Create the Spring security Super User class
     */
	private final static class UserRepositoryUserDetails extends User implements UserDetails {

		private static final long serialVersionUID = 1L;

		private UserRepositoryUserDetails(User user) {
			super(user);
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return AuthorityUtils.createAuthorityList(super.getRole());
		}

		@Override
		public String getUsername() {
			return super.getUsername();
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return super.isActive();
		}

	}



}
