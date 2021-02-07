package com.tamercan.Repository;

import com.tamercan.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    boolean existsByUsernameAndPassword(String username, String password);

    boolean existsByUsername(String username);

    @Modifying
    @Transactional
    @Query(value = "update public.user set password = :password where username = :username", nativeQuery = true)
    void updatePasswordByUsername(@Param("username") String username, @Param("password") String password);

    @Modifying
    @Transactional
    @Query(value = "insert into public.user (username,password) values(:username,:password)", nativeQuery = true)
    void createUser(@Param("username") String username, @Param("password") String password);


}
