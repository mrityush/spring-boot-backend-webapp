package com.src.main.services.implementations.users;

import com.src.main.dao.interfaces.users.UserAuthorityDao;
import com.src.main.dao.interfaces.users.UserDao;
import com.src.main.domains.users.User;
import com.src.main.domains.users.UserAuthority;
import com.src.main.domains.users.UserEntity;
import com.src.main.dto.users.UserDTO;
import com.src.main.services.implementations.AbstractService;
import com.src.main.services.interfaces.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mj on 1/6/16.
 */
@Service
public class UserServiceImpl extends AbstractService<User, UserDTO> implements UserService<UserEntity> {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserAuthorityDao userAuthorityDao;

    @Override
    public UserDTO authenticateUser(String userName) {
        User user = new User();//TODO remove userDao.getUserByNameAndPassword(userName, password);
        UserDTO userDTO = null;
        if (user != null) {
            UserAuthority userAuthority = userAuthorityDao.findByUserId(user.getId());
            userDTO = new UserDTO(user.getId(), userAuthority.getAuthToken(), userAuthority.getAuthority());
        }
        return userDTO;
    }

    @Override
    public UserDTO testService(String authToken) {
        //TODO will apply the decryption/etc formula in authtoken.
        System.out.println("COming to TestService + userId = " + authToken);
        User user = userDao.get(Long.valueOf(authToken));
        UserAuthority userAuthority = userAuthorityDao.findByUserId(user.getId());
        UserDTO userDTO = new UserDTO(user.getId(), userAuthority.getAuthToken(), userAuthority.getAuthority());
        return userDTO;
    }
}
