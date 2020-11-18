package com.radoslav.dodnikov.social_platform.comments;

import com.radoslav.dodnikov.social_platform.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    User findByUsername(String username);

}
