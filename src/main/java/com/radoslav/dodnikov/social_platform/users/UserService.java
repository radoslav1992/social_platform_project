package com.radoslav.dodnikov.social_platform.users;

import com.radoslav.dodnikov.social_platform.users.authorities.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    public void addFriend(Long userId, Long friendId) {
        User user = userRepository.getUserWithFriends(userId);
        User friend = userRepository.getUserWithFriends(friendId);

        user.addFriend(friend);
        friend.addFriend(user);

        userRepository.saveAndFlush(user);
        userRepository.saveAndFlush(friend);
    }



}
