package com.src.main.classconverters.cotodomain.users;

import com.src.main.classconverters.COToDomain;
import com.src.main.classconverters.cotodomain.AbstractCOToDomainConverter;
import com.src.main.command.users.UserCO;
import com.src.main.domains.users.User;
import org.springframework.stereotype.Component;

/**
 * Created by mj on 25/5/16.
 */
@Component
public class UserCOToDomainConverter extends AbstractCOToDomainConverter implements COToDomain<User, UserCO> {

    @Override
    public User convert(UserCO userCO, Long userId, boolean isCreated) throws Exception {
        User user = new User();
        updateStatus(userCO, user);
        //TODO ... not filled the fields in CO
        if (isCreated)
            user = (User) addCreationDetails(user, userId);
        user = (User) addModificationDetails(user, userId);
        return user;
    }
}
