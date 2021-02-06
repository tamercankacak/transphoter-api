package com.tamercan.Repository;

import com.tamercan.Entity.Words;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface WordsRepository extends JpaRepository<Words, Long> {


    Words findById(int id);

    boolean existsByEnglishwordAndTurkishword(String englishword, String turkishword);

    @Modifying
    @Transactional
    @Query(value = "insert into public.words (englishword,turkishword) values(:englishword,:turkishword)", nativeQuery = true)
    void createWords(@Param("englishword") String englishword, @Param("turkishword") String turkishword);
}
