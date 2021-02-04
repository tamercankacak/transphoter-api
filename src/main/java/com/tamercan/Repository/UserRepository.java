package com.tamercan.Repository;

import com.tamercan.Entity.User;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    boolean existsByUsernameAndPassword(String username, String password);

    boolean existsByUsername(String username);

    @Modifying
    @Query(value = "update User user set user.password = :password where user.username = :username", nativeQuery = true)
    void updatePasswordByUsername(String username, String password);



}
