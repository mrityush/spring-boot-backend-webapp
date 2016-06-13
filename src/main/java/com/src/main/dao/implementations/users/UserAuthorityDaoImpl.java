package com.src.main.dao.implementations.users;

import com.src.main.dao.interfaces.users.UserAuthorityDao;
import com.src.main.dao.interfaces.users.UserDao;
import com.src.main.domains.entity.CommonDataEntity;
import com.src.main.domains.users.User;
import com.src.main.domains.users.UserAuthority;
import com.src.main.repository.users.UserAuthorityRepository;
import com.src.main.searchfilter.users.UserAuthoritySearchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mj on 27/5/16.
 */
@Component
class UserAuthorityDaoImpl implements UserAuthorityDao {

    @Autowired
    private UserAuthorityRepository userAuthorityRepository;

    @Autowired
    UserDao userDao;


    @Override
    public List<UserAuthority> findItems(UserAuthoritySearchFilter userAuthoritySearchFilter) {
        List<UserAuthority> userAuthorities = new ArrayList<>();

        Pageable pageable = new PageRequest(userAuthoritySearchFilter.getOffset(), userAuthoritySearchFilter.getMax(),
                new Sort(Sort.Direction.DESC, CommonDataEntity.DATE_CREATED));
        userAuthorities = userAuthorityRepository.findAll(pageable).getContent();
        return userAuthorities;
    }

    @Override
    public UserAuthority save(UserAuthority userAuthority) {
        return userAuthorityRepository.save(userAuthority);
    }

    @Override
    public UserAuthority update(UserAuthority userAuthority) {
        return save(userAuthority);
    }

    @Override
    public UserAuthority get(Long id) {
        return userAuthorityRepository.findOne(id);
    }

    @Override
    public List<UserAuthority> findAll() {
        return userAuthorityRepository.findAll();
    }

    @Override
    public long count() {
        return userAuthorityRepository.count();
    }

    @Override
    public UserAuthority findByUserId(Long id) {
        User user = userDao.get(id);
        return userAuthorityRepository.findByUser(user);
    }

    @Override
    public UserAuthority findByAuthToken(String authToken) {
        return userAuthorityRepository.findByAuthToken(authToken);
    }
}
