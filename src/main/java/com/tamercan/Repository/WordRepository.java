package com.tamercan.Repository;

import com.tamercan.Entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {


    Word findById(long id);

    boolean existsById(long id);

    boolean existsByEnglishwordAndTurkishword(String englishword, String turkishword);

    @Modifying
    @Transactional
    @Query(value = "insert into public.word (englishword,turkishword) values(:englishword,:turkishword)", nativeQuery = true)
    void createWord(@Param("englishword") String englishword, @Param("turkishword") String turkishword);
}
