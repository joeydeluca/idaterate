package com.idaterate.infrastructure.repositories;

import com.idaterate.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Joe Deluca on 05/11/2015.
 */
public interface IUserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByUsername(String username);
}
