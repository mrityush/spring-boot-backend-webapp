package com.src.main.services.interfaces.users;

import com.src.main.domains.users.UserEntity;
import com.src.main.dto.users.UserDTO;
import com.src.main.services.BaseService;

/**
 * Created by mj on 26/5/16.
 */
public interface UserService<T extends UserEntity> extends BaseService<T> {
    UserDTO authenticateUser(String userName);

    UserDTO testService(String password);

}
