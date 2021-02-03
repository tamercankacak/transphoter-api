package com.tamercan.Repository;

import com.tamercan.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByUsernameAndPassword(String username, String password);

    boolean existsByUsername(String username);

    @Modifying
    @Query("update User user set user.password = :password where user.username = :username")
    void updatePasswordByUsername(@Param("username") String username,@Param("password") String password);



}
