package com.src.main.dao.interfaces.users;

import com.src.main.dao.interfaces.BaseDao;
import com.src.main.domains.users.UserAuthority;
import com.src.main.searchfilter.users.UserAuthoritySearchFilter;

/**
 * Created by mj on 22/5/16.
 */

public interface UserAuthorityDao extends BaseDao<UserAuthority, UserAuthoritySearchFilter> {
    UserAuthority findByUserId(Long id);

    UserAuthority findByAuthToken(String authToken);
}
