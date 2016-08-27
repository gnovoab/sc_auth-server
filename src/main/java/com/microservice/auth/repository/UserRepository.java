
//Namespace
package com.microservice.auth.repository;

//Imports
import com.microservice.auth.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class that handles database operations for Conversation
 */
@Transactional
public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}
