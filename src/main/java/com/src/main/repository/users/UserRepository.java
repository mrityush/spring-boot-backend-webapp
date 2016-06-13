package com.src.main.repository.users;

import com.src.main.domains.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserNameAndPassword(String userName, String password);

    User findByEmailAndPassword(String userName, String password);
}
