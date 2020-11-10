package com.radoslav.dodnikov.social_platform.users;

import com.radoslav.dodnikov.social_platform.communities.Community;
import com.radoslav.dodnikov.social_platform.interfaces.AbstractEntity;
import com.radoslav.dodnikov.social_platform.users.authorities.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends AbstractEntity implements UserDetails {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "image")
    private byte[] image;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "followers",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "follower_id")})
    private Set<User> followers;

    @ManyToMany(mappedBy = "followers", fetch = FetchType.LAZY)
    private Set<User> following;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "friends",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "friend_id")})
    private Set<User> friends;

    @ManyToMany(mappedBy = "friends", fetch = FetchType.LAZY)
    private Set<User> friendsOf;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_authorities",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id")})
    private Set<Authority> authorities;

    private Set<Community> communities;

    public User() {
        this.followers = new HashSet<>();
        this.following = new HashSet<>();
        this.friends = new HashSet<>();
        this.friendsOf = new HashSet<>();
        this.authorities = new HashSet<>();
        this.communities = new HashSet<>();
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.followers = new HashSet<>();
        this.following = new HashSet<>();
        this.friends = new HashSet<>();
        this.friendsOf = new HashSet<>();
        this.authorities = new HashSet<>();
        this.communities = new HashSet<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<User> followers) {
        this.followers = followers;
    }

    public void addFollower(User follower) {
        this.followers.add(follower);
    }

    public Set<User> getFollowing() {
        return following;
    }

    public void setFollowing(Set<User> following) {
        this.following = following;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public void addFriend(User friend) {
        this.friends.add(friend);
    }

    public Set<User> getFriendsOf() {
        return friendsOf;
    }

    public void setFriendsOf(Set<User> friendsOf) {
        this.friendsOf = friendsOf;
    }

    public Set<Community> getCommunities() {
        return communities;
    }

    public void setCommunities(Set<Community> communities) {
        this.communities = communities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public Collection<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

}
