package com.radoslav.dodnikov.social_platform.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Query("SELECT u FROM User LEFT JOIN FETCH u.friends WHERE u = (:id)")
    User getUserWithFriends(@Param("id") Long id);

}
