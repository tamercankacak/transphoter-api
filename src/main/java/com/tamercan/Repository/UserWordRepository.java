package com.tamercan.Repository;

import com.tamercan.Entity.UserWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserWordRepository extends JpaRepository<UserWord,Long> {

    UserWord findById(long id);

    UserWord findByUserIdAndWordId(long userId,long wordId);

    boolean existsById(long id);

    boolean existsByUserIdAndWordId(long userId,long wordId);

    @Modifying
    @Transactional
    @Query(value = "insert into public.userWord (userId,wordId) values(:userId,:wordId)", nativeQuery = true)
    void createUserWord(@Param("userId") long userId, @Param("wordId") long wordId);

}
