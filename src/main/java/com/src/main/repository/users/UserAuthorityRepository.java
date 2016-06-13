package com.src.main.repository.users;

import com.src.main.domains.users.User;
import com.src.main.domains.users.UserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserAuthorityRepository extends JpaRepository<UserAuthority, Long> {
    UserAuthority findByUser(User user);

    UserAuthority findByAuthToken(String authToken);
}
