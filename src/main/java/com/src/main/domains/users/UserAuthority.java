package com.src.main.domains.users;

import javax.persistence.*;

/**
 * Created by mj on 22/5/16.
 */

@Entity(name = "user_authority")
@Table(name = "user_authority"
        , uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "authority", "auth_token"}))
public class UserAuthority extends UserEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(nullable = false, unique = false)
    private Integer authority;

    @Column(nullable = false, unique = true, name = "auth_token")
    private String authToken;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
