package com.src.main.dto.users;

import com.src.main.domains.users.User;
import com.src.main.dto.BaseDTO;
import org.springframework.stereotype.Component;

/**
 * Created by mj on 25/5/16.
 */
@Component
public class UserDTO implements BaseDTO<User> {
    private Long id;
    private String authToken;
    private Integer authority;

    public UserDTO() {
    }

    public UserDTO(Long id, String authToken, Integer authority) {
        this.id = id;
        this.authToken = authToken;
        this.authority = authority;

    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
