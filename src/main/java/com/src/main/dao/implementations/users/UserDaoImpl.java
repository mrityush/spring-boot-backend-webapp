package com.src.main.dao.implementations.users;

import com.src.main.dao.interfaces.users.UserDao;
import com.src.main.domains.entity.CommonDataEntity;
import com.src.main.domains.users.User;
import com.src.main.repository.users.UserRepository;
import com.src.main.searchfilter.users.UserSearchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mj on 22/5/16.
 */
@Component
class UserDaoImpl implements UserDao {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findItems(UserSearchFilter userSearchFilter) {
        List<User> users = new ArrayList<>();

        Pageable pageable = new PageRequest(userSearchFilter.getOffset(), userSearchFilter.getMax(),
                new Sort(Sort.Direction.DESC, CommonDataEntity.DATE_CREATED));
        users = userRepository.findAll(pageable).getContent();
        return users;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return save(user);
    }

    @Override
    public User get(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    /**
     * We are setting search fields as username as well as email... can be removed later if need arises
     * For now, the user can enter either his email or his username to login
     *
     * @param userName
     * @param password
     * @return
     */
    @Override
    public User getUserByNameAndPassword(String userName, String password) {
        User user = userRepository.findByUserNameAndPassword(userName, password);
        if (user == null) {
            user = userRepository.findByEmailAndPassword(userName, password);
        }
        return user;
    }
}
